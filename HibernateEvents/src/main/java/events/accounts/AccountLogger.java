package events.accounts;

import org.apache.log4j.Logger;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

public class AccountLogger extends DefaultSaveOrUpdateEventListener {
    Logger logger = Logger.getLogger(AccountLogger.class);
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event){
        if(event.getEntity() instanceof Account){
            logger.debug("New Account added. Account number: " +  ((Account) event.getEntity()).getAccountNumber());
        }

    }

}
