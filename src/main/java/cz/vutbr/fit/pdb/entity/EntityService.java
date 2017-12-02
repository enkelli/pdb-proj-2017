package cz.vutbr.fit.pdb.entity;

import cz.vutbr.fit.pdb.utils.DummyData;
import javafx.collections.ObservableList;

public class EntityService {

    public static void addEntity(Entity entity) {
        DummyData.addEntity(entity);
    }

    public ObservableList<Entity> getEntities() {
        return DummyData.getEntities();
    }
}