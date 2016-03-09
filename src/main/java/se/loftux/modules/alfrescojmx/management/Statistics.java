package se.loftux.modules.alfrescojmx.management;

import lombok.Setter;
import org.alfresco.repo.transaction.RetryingTransactionHelper.RetryingTransactionCallback;
import org.alfresco.service.cmr.security.AuthorityService;
import org.springframework.jmx.export.annotation.ManagedResource;
import se.loftux.modules.alfrescojmx.management.core.ReadOnlyMBean;

/**
 * Read only bean providing statistics on running Alfresco instance.
 */
@ManagedResource(objectName="Alfresco:name=Statistics")
public class Statistics extends ReadOnlyMBean implements StatisticsMBean
{
    @Setter AuthorityService authorityService;

    @Override
    public int getNumberOfGroups()
    {
        return doWork(new RetryingTransactionCallback<Integer>()
        {
            public Integer execute() throws Throwable
            {
                return (int) authorityService.countGroups();
            }
        });
    }

    @Override
    public int getNumberOfUsers()
    {
        return doWork(new RetryingTransactionCallback<Integer>()
        {
            public Integer execute() throws Throwable
            {
                return (int) authorityService.countUsers();
            }
        });
    }
}
