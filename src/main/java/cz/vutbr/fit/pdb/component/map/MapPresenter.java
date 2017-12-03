package cz.vutbr.fit.pdb.component.map;

import cz.vutbr.fit.pdb.configuration.AppMode;
import cz.vutbr.fit.pdb.configuration.Configuration;
import cz.vutbr.fit.pdb.entity.EntityService;
import cz.vutbr.fit.pdb.painter.Painter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import lombok.extern.java.Log;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@Log
public class MapPresenter implements Initializable {
    @FXML
    private Canvas canvas;

    @Inject
    private EntityService entityService;

    @Inject
    private Configuration configuration;

    private Painter painter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.painter = new Painter(canvas.getGraphicsContext2D(), entityService, configuration);
        this.canvas.setOnMouseClicked(this::onMouseClicked);
        this.painter.paintAll(entityService.getEntities());
    }

    private void onMouseClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        log.info(String.format("Clicked on canvas at[%f,%f]", x, y));
        if (configuration.getAppMode() == AppMode.VIEW)
            entityService.tryToSelectEntityAt(x, y);
        else if (configuration.getAppMode() == AppMode.EDIT)
            painter.clicked(x, y);
        else throw new RuntimeException("Not impl yet");
    }
}