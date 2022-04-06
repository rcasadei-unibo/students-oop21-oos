package view;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ShopViewImpl implements ShopView {

    private final View view; 
    private final Stage stage; 
    private final Pane pane; 

    //Check all of the sizes!!!
    private static final int FONT_SIZE = 18; 
    private static final int BUTTON_WIDTH = 130; 
    private static final int BUTTON_X = 340; 
    private static final int BUY_BUTTON_Y = 320; 
    private static final int SELECT_BUTTON_Y = 370; 
    private static final int ARROW_WIDTH = 50; 
    private static final int ARROW_BUTTON_X = 240; 
    private static final int ARROW_DXBUTTON_X = 510; 
    private static final int ARROW_BUTTON_Y = 200; 
    private static final int SKIN_BUTTON_WIDTH = 250; 
    private static final int SKIN_BUTTON_X = 180; 
    private static final int SKIN_BUTTON_Y = 50; 
    private static final int ARROW_HEIGTH = 40; 

    public ShopViewImpl(final View view, final Stage stage, final Pane pane) {
        super(); 
        this.view = view; 
        this.stage = stage; 
        this.pane = pane; 
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        final Button buy = new Button(); 
        buy.setLayoutX(BUTTON_X);
        buy.setLayoutY(BUY_BUTTON_Y);
        buy.setPrefWidth(BUTTON_WIDTH);
        buy.setTextAlignment(TextAlignment.CENTER);
        buy.setFont(new Font("Arial", FONT_SIZE));
        buy.setText("BUY"); 
        buy.setOnAction(e -> {
            buy.setDisable(false); 
        });

        final Button select = new Button(); 
        select.setLayoutX(BUTTON_X);
        select.setLayoutY(SELECT_BUTTON_Y);
        select.setPrefWidth(BUTTON_WIDTH);
        select.setTextAlignment(TextAlignment.CENTER);
        select.setFont(new Font("Arial", FONT_SIZE));
        select.setText("SELECT"); 
        select.setOnAction(e -> {
            select.setDisable(false); 
        });

        final ImageView dxArr = new ImageView(); 
        dxArr.setImage(new Image("ArrowDx.png"));
        dxArr.setFitHeight(ARROW_HEIGTH); 
        dxArr.setPreserveRatio(true);

        final ImageView sxArr = new ImageView(); 
        sxArr.setImage(new Image("ArrowSx.png"));
        sxArr.setFitHeight(ARROW_HEIGTH); 
        sxArr.setPreserveRatio(true);

        final Button dxArrow = new Button(); 
        dxArrow.setLayoutX(ARROW_DXBUTTON_X);
        dxArrow.setLayoutY(ARROW_BUTTON_Y);
        dxArrow.setPrefWidth(ARROW_WIDTH);
        dxArrow.setGraphic(dxArr); 

        final Button sxArrow = new Button(); 
        sxArrow.setLayoutX(ARROW_BUTTON_X);
        sxArrow.setLayoutY(ARROW_BUTTON_Y);
        sxArrow.setPrefWidth(ARROW_WIDTH);
        sxArrow.setGraphic(sxArr);

        this.pane.getChildren().add(buy); 
        this.pane.getChildren().add(select); 
        this.pane.getChildren().add(dxArrow); 
        this.pane.getChildren().add(sxArrow); 

    }

}
