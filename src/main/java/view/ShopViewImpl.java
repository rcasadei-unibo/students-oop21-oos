package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Statistics;
import model.StatisticsImpl;
import model.shop.Shop;
import model.shop.ShopImpl;
import model.shop.ShopItem;

public class ShopViewImpl implements ShopView {

    private final View view; 
    private final Pane pane; 
    private final Shop shop; 
    private final Statistics stats; 
    private Image shopWallpaper; 
    private List<ImageView> skins = new ArrayList<>(); 
    private List<ShopItem> shopSkins; 
    private int skinsCounter; 

    private static final int FONT_SIZE = 18; 
    private static final int BUTTON_WIDTH = 130; 
    private static final int BUTTON_X = 340; 
    private static final int BUY_BUTTON_Y = 320; 
    private static final int SELECT_BUTTON_Y = 370; 
    private static final int SQUARE_WIDTH = 50; 
    private static final int ARROW_BUTTON_X = 240; 
    private static final int ARROW_DXBUTTON_X = 510; 
    private static final int ARROW_BUTTON_Y = 200; 
    private static final int SQUARE_HEIGTH = 40; 
    private static final int SHOPTITLE_X = 330; 
    private static final int SKIN_X = 357; 
    private static final int SKIN_Y = 130; 
    private static final int ARC = 20;
    private static final int BACKGROUND_WIDTH = 854;
    private static final int BACKGROUND_HEIGTH = 480;
    private static final int HOMEBTN_X = 700;
    private static final int MYSTBOX_HEIGHT = 80; 
    private static final int MYSTBOX_X = 40;
    private static final int MYSTBOX_Y = 310; 
    private static final int COINS_X = 10;
    private static final int COINS_Y = 30; 

    public ShopViewImpl(final View view, final Pane pane) {
        super(); 
        this.view = view; 
        this.pane = pane; 
        this.stats = new StatisticsImpl(); 
        this.shop = new ShopImpl(); 
        skinsCounter = 0;
        shopSkins = this.shop.getItems(); 
    }

    @Override
    public void render() {

        final ImageView title = new ImageView(new Image("Shop.png"));
        title.setLayoutX(SHOPTITLE_X);
        title.setLayoutY(0); 

        final ImageView programmerSkin = new ImageView(new Image("ProgrammerSkin.png")); 
        programmerSkin.setLayoutX(SKIN_X);
        programmerSkin.setLayoutY(SKIN_Y);

        final ImageView dinoSkin = new ImageView(new Image("DinoSkin.png")); 
        dinoSkin.setLayoutX(SKIN_X);
        dinoSkin.setLayoutY(SKIN_Y);

        skins.add(programmerSkin); 
        skins.add(dinoSkin); 

        final Button buy = new Button(); 
        buy.setLayoutX(BUTTON_X);
        buy.setLayoutY(BUY_BUTTON_Y);
        buy.setPrefWidth(BUTTON_WIDTH);
        buy.setTextAlignment(TextAlignment.CENTER);
        buy.setFont(new Font("Arial", FONT_SIZE));
        buy.setText("BUY"); 
        buy.setOnAction(e -> {
            shop.shopItemPayment(shopSkins.get(skinsCounter), stats); 
            System.out.println(stats.getTotalCoins()); 
            renderCoins(); 
            //SALVARE
        });

        final Button select = new Button(); 
        select.setLayoutX(BUTTON_X);
        select.setLayoutY(SELECT_BUTTON_Y);
        select.setPrefWidth(BUTTON_WIDTH);
        select.setTextAlignment(TextAlignment.CENTER);
        select.setFont(new Font("Arial", FONT_SIZE));
        select.setText("SELECT"); 
        select.setOnAction(e -> {
            select.setText("SELECTED"); 
            //SALVARE
        });

        final ImageView dxArr = new ImageView(); 
        dxArr.setImage(new Image("ArrowDx.png"));
        dxArr.setFitHeight(SQUARE_HEIGTH); 
        dxArr.setPreserveRatio(true);

        final ImageView sxArr = new ImageView(); 
        sxArr.setImage(new Image("ArrowSx.png"));
        sxArr.setFitHeight(SQUARE_HEIGTH); 
        sxArr.setPreserveRatio(true);

        final ImageView startIm = new ImageView(); 
        startIm.setImage(new Image("StartGame.png"));
        startIm.setFitHeight(MYSTBOX_HEIGHT);
        startIm.setPreserveRatio(true);

        final ImageView mysteryBoxIm = new ImageView(); 
        mysteryBoxIm.setImage(new Image("MysteryBox.png"));
        mysteryBoxIm.setFitHeight(MYSTBOX_HEIGHT);
        mysteryBoxIm.setPreserveRatio(true);

        final Button dxArrow = new Button(); 
        dxArrow.setLayoutX(ARROW_DXBUTTON_X);
        dxArrow.setLayoutY(ARROW_BUTTON_Y);
        dxArrow.setPrefWidth(SQUARE_WIDTH);
        dxArrow.setGraphic(dxArr); 
        dxArrow.setOnAction(e -> {
            increaseSkinCounter(); 
        });

        final Button sxArrow = new Button(); 
        sxArrow.setLayoutX(ARROW_BUTTON_X);
        sxArrow.setLayoutY(ARROW_BUTTON_Y);
        sxArrow.setPrefWidth(SQUARE_WIDTH);
        sxArrow.setGraphic(sxArr);
        sxArrow.setOnAction(e -> {
            decreaseSkinCounter(); 
        });

        final Button startGame = new Button(); 
        startGame.setLayoutX(HOMEBTN_X);
        startGame.setLayoutY(MYSTBOX_Y);
        startGame.setPrefWidth(SQUARE_WIDTH);
        startGame.setGraphic(startIm);
        startGame.setOnAction(e -> {
            pane.getChildren().clear(); 
            this.view.getController().start();
            //SALVARE
        });

        final Button mysteryBox = new Button(); 
        mysteryBox.setLayoutX(MYSTBOX_X);
        mysteryBox.setLayoutY(MYSTBOX_Y);
        mysteryBox.setPrefWidth(MYSTBOX_HEIGHT);
        mysteryBox.setGraphic(mysteryBoxIm);
        mysteryBox.setOnAction(e -> {
            //PAGAMENTO MYSTERYBOX
            final Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Premio"); 
            alert.setHeaderText(null); 
            alert.setContentText("Prova prova"); 
            alert.showAndWait(); 
            //SALVARE
        });

        //INDICATORE MONETE
        renderCoins();

        final Rectangle rectangle = new Rectangle(345, 120, 120, 170); 
        rectangle.setFill(Color.LIGHTPINK);
        rectangle.setArcHeight(ARC);
        rectangle.setArcWidth(ARC);
        final Rectangle outerRec = new Rectangle(340, 115, 130, 180); 
        outerRec.setFill(Color.BLACK);
        outerRec.setArcHeight(ARC);
        outerRec.setArcWidth(ARC);

        this.shopWallpaper = new Image("ShopBackground.jpg", BACKGROUND_WIDTH, BACKGROUND_HEIGTH, false, true); 
        final BackgroundImage shopBackground = new BackgroundImage(shopWallpaper, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT); 

        this.pane.getChildren().add(buy); 
        this.pane.getChildren().add(select); 
        this.pane.getChildren().add(startGame); 
        this.pane.getChildren().add(dxArrow); 
        this.pane.getChildren().add(sxArrow); 
        this.pane.getChildren().add(title); 
        this.pane.getChildren().add(outerRec); 
        this.pane.getChildren().add(rectangle);
        this.pane.getChildren().add(skins.get(skinsCounter)); 
        this.pane.getChildren().add(mysteryBox); 

        this.pane.setBackground(new Background(shopBackground));

    }

    private void renderCoins() {
        final Text coins = new Text("Coins: " + stats.getTotalCoins()); 
        coins.setFont(new Font("Arial", FONT_SIZE));
        coins.setLayoutX(COINS_X);
        coins.setLayoutY(COINS_Y);
        this.pane.getChildren().add(coins); 
    }

    private void increaseSkinCounter() {
        this.pane.getChildren().remove(skins.get(skinsCounter));
        skinsCounter++; 
        if (skinsCounter >= skins.size()) {
            skinsCounter = 0; 
        }
        this.pane.getChildren().add(skins.get(skinsCounter));
    }

    private void decreaseSkinCounter() {
        this.pane.getChildren().remove(skins.get(skinsCounter));
        skinsCounter--; 
        if (skinsCounter < 0) {
            skinsCounter = skins.size() - 1; 
        }
        this.pane.getChildren().add(skins.get(skinsCounter)); 
    }

}
