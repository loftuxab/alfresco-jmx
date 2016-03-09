package se.loftux.modules.alfrescojmx.management;


public interface StatisticsMBean
{
    /**
     * Gets the number of users.
     * 
     * @return the number of users
     */
    int getNumberOfUsers();

    /**
     * Gets the number of groups.
     * 
     * @return the number of groups
     */
    int getNumberOfGroups();
}
