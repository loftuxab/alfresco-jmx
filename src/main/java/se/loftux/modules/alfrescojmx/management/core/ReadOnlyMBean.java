package se.loftux.modules.alfrescojmx.management.core;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.transaction.AlfrescoTransactionSupport;
import org.alfresco.repo.transaction.RetryingTransactionHelper;
import org.alfresco.service.transaction.TransactionService;

/**
 * Created by bhagyasilva on 08/03/16.
 */
@Log4j
public class ReadOnlyMBean {

    @Setter
    TransactionService transactionService;

    /**
     * Do some work in the context of an Alfresco transaction, authenticated as the system user.
     *
     * @param callback
     *            the callback to do the work
     * @return the result of the callback
     */
    protected <T> T doWork(final RetryingTransactionHelper.RetryingTransactionCallback<T> callback)
    {
        return AuthenticationUtil.runAs(new AuthenticationUtil.RunAsWork<T>()
        {
            public T doWork() throws Exception
            {
                try
                {
                    boolean readOnly = transactionService.isReadOnly();
                    boolean requiresNew = !readOnly && AlfrescoTransactionSupport.getTransactionReadState() == AlfrescoTransactionSupport.TxnReadState.TXN_READ_ONLY;
                    return ReadOnlyMBean.this.transactionService.getRetryingTransactionHelper().doInTransaction(
                            callback, true, requiresNew);
                }
                catch (Exception e)
                {
                    log.error(e);
                    throw e;
                }
            }
        }, AuthenticationUtil.getSystemUserName());
    }
}
