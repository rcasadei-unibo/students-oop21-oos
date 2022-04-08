package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ShopViewImpl implements ShopView {

    private final View view; 
    private final Stage stage; 
    private final Pane pane; 
    private Image shopWallpaper; 

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
    private static final int ARROW_HEIGTH = 40; 
    private static final int SHOPTITLE_X = 330; 

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

        final ImageView title = new ImageView(new Image("Shop.png"));
        title.setLayoutX(SHOPTITLE_X);
        title.setLayoutY(0); 

        final ImageView programmerSkin = new ImageView(new Image("ProgrammerSkin.png")); 
        programmerSkin.setLayoutX(357);
        programmerSkin.setLayoutY(130);

        final Rectangle rectangle = new Rectangle(345, 120, 120, 170); 
        rectangle.setFill(Color.LIGHTPINK);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        final Rectangle outerRec = new Rectangle(340, 115, 130, 180); 
        outerRec.setFill(Color.BLACK);
        outerRec.setArcHeight(20);
        outerRec.setArcWidth(20);

        this.shopWallpaper = new Image("ShopBackground.jpg", 854, 480, false, true); 
        final BackgroundImage shopBackground = new BackgroundImage(shopWallpaper, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT); 

        this.pane.getChildren().add(buy); 
        this.pane.getChildren().add(select); 
        this.pane.getChildren().add(dxArrow); 
        this.pane.getChildren().add(sxArrow); 
        this.pane.getChildren().add(title); 
        this.pane.getChildren().add(outerRec); 
        this.pane.getChildren().add(rectangle);
        this.pane.getChildren().add(programmerSkin); 

        this.pane.setBackground(new Background(shopBackground));

    }

}
