package hu.zsolt.damu.betVictor.service;

import hu.zsolt.damu.betVictor.domains.SavedObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by TamasZsolt on 30/06/2015.
 */
public class SavedObjectService extends AbstractGenericService<SavedObject> {

    private final static Logger LOGGER = LoggerFactory.getLogger(SavedObject.class);

    @Override
    public SavedObject findById(Long id) {
        return null;
    }

    public SavedObject createSavedObject(String comment) {
        LOGGER.info("Create an Saved Object with comment: " + comment);
        SavedObject savedObject = new SavedObject(comment);
        persist(savedObject);
        return savedObject;
    }
}
