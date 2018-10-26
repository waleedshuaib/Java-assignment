import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * @author waleed shuaib 1161216 sec 5
 */
public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		try {
			ImageView image = new ImageView(); // to set image
			Image image1 = new Image("image2.jpg");
			image.setFitHeight(800);
			image.setFitWidth(1000);
			image.setImage(image1);
			pane.getChildren().add(image);
	
		} catch (Exception e) {
			System.out.println("Error in the image!!!!!");
			e.printStackTrace();
		}
		Rectangle R = new Rectangle(100, 75, 800, 500); // Rectangle
		R.setFill(Color.BLACK);
		R.setStroke(Color.RED);R.setOpacity(0.75);R.setArcHeight(150);R.setArcWidth(150);
		pane.getChildren().add(R);

		GridPane gpane = new GridPane(); // GridPane

		Label L1 = new Label("Costumer Name :"); // Label one
		L1.setTextFill(Color.RED);
		gpane.add(L1, 0, 0);
		TextField T1 = new TextField();
		gpane.add(T1, 1, 0);
		Label L2 = new Label("Pizza Size :"); // Label 2
		L2.setTextFill(Color.RED);
		gpane.add(L2, 0, 1);
		ComboBox<Object> cbo = new ComboBox<>(); // comboBox
		cbo.getItems().addAll("Small", "Medium", "Large");
		cbo.setValue("Small");
		gpane.add(cbo, 1, 1);

		Label L3 = new Label("Order Type :"); // Label 3
		L3.setTextFill(Color.RED);
		gpane.add(L3, 0, 2);
		RadioButton Rbt = new RadioButton(); // RadioButtons
		Rbt.setText("ToGo");Rbt.setTextFill(Color.BLUE);Rbt.setSelected(true);
		gpane.add(Rbt, 1, 2);
		RadioButton Rbt2 = new RadioButton();
		Rbt2.setText("Seated");Rbt2.setTextFill(Color.BLUE);
		gpane.add(Rbt2, 2, 2);
		RadioButton Rbt3 = new RadioButton();
		Rbt3.setText("Delivery");Rbt3.setTextFill(Color.BLUE);
		gpane.add(Rbt3, 3, 2);

		ToggleGroup group = new ToggleGroup(); // ToggleGroup for RadioButtons
		Rbt.setToggleGroup(group);
		Rbt2.setToggleGroup(group);
		Rbt3.setToggleGroup(group);

		Label L4 = new Label("List Of Toppings :"); // Label 4
		L4.setTextFill(Color.RED);
		gpane.add(L4, 0, 3);

		CheckBox cbox = new CheckBox(); // checkBox
		cbox.setText("Onion");cbox.setTextFill(Color.BLUE);
		gpane.add(cbox, 1, 3);
		CheckBox cbox2 = new CheckBox();
		cbox2.setText("Olives");cbox2.setTextFill(Color.BLUE);
		gpane.add(cbox2, 2, 3);
		CheckBox cbox3 = new CheckBox();
		cbox3.setText("Green Peppers");cbox3.setTextFill(Color.BLUE);
		gpane.add(cbox3, 3, 3);

		Label L5 = new Label("Tip Rate  :"); // Label 5
		L5.setTextFill(Color.RED);
		TextField T2 = new TextField("0.0");
		Label L6 = new Label("Order Price  :"); // Label 6
		L6.setTextFill(Color.RED);
		gpane.add(L6, 0, 5);
		TextField T3 = new TextField("0.0");
		gpane.add(T3, 1, 5);
		Label L7 = new Label("service Charge :"); // Label 7
		L7.setTextFill(Color.RED);
		TextField T4 = new TextField("0.0");
		Label L8 = new Label("Topping Price  :"); // Label 8
		gpane.add(L8, 0, 4);
		L8.setTextFill(Color.RED);
		TextField T5 = new TextField("10");
		gpane.add(T5, 1, 4);

		Button ProcessOrder = new Button("ProcessOrder"); // Buttons
		ProcessOrder.setContentDisplay(ContentDisplay.BOTTOM);// to set position
		gpane.add(ProcessOrder, 0, 11);

		Button PrintOrders = new Button("PrintOrders");
		gpane.add(PrintOrders, 2, 11);
		PrintOrders.setContentDisplay(ContentDisplay.BOTTOM);
		Button Reset = new Button("Reset");
		gpane.add(Reset, 4, 11);
		Reset.setContentDisplay(ContentDisplay.BOTTOM);

		gpane.setHgap(10);
		gpane.setVgap(20);
		gpane.setPadding(new Insets(130, 0, 0, 190));

		ArrayList<PizzaOrder> Orders = new ArrayList<>();

		Reset.setOnAction(e -> {// rest all value of the elements in the order to the default
			T5.setText("10");T4.setText("0.0");T3.setText("0.0");T2.setText("0.0");T1.setText("");
			cbox.setSelected(false);cbox2.setSelected(false);
			cbox3.setSelected(false);Rbt2.setSelected(false);Rbt3.setSelected(false);Rbt.setSelected(true);
			cbo.setValue("Small");
			gpane.getChildren().removeAll(T2, L5);
			gpane.getChildren().removeAll(T4, L7);
		});

		Rbt.setOnAction(e1 -> {
			if (gpane.getChildren().size() > 19) { // 19 Because the size(number of elements) of grid pane is 19
				gpane.getChildren().removeAll(T2, L5);
				gpane.getChildren().removeAll(T4, L7);
			}
		});
		Rbt2.setOnAction(e2 -> {

			if (gpane.getChildren().size() > 19) { // hide two elements 
				gpane.getChildren().removeAll(T2, L5);
			}

			if (gpane.getChildren().size() == 19) {
				gpane.add(T4, 1, 6);
				gpane.add(L7, 0, 6);
			}
		});
		Rbt3.setOnAction(e3 -> {
			if (gpane.getChildren().size() > 19) {
				gpane.getChildren().removeAll(T4, L7);
			}

			if (gpane.getChildren().size() == 19) {
				gpane.add(T2, 1, 6);
				gpane.add(L5, 0, 6);
			}
		});

		ProcessOrder.setOnAction(e4 -> {
				

			try {

				Double service=Double.parseDouble(T4.getText()); // this statements to convert the text to double
				Double tip=Double.parseDouble(T2.getText());
				Double toppingPrice=Double.parseDouble(T5.getText());
				
				if(!cbox.isSelected()&&!cbox2.isSelected()&&!cbox3.isSelected()) // this is to put the numOfToppings at least to 1
					throw new Exception();
				{
					if (Rbt.isSelected()) {
						ToGo togo = new ToGo();
						int x = togo.getNumOfToppings();
						if (cbox.isSelected())
							x++;
						if (cbox2.isSelected())
							x++;
						if (cbox3.isSelected())
							x++;
						togo.setNumOfToppings(x);
						togo.setToppingPrice(toppingPrice);
						if (cbo.getValue() == "Small")
							togo.setPizzaSize(1);
						if (cbo.getValue() == "Medium")
							togo.setPizzaSize(2);
						if (cbo.getValue() == "Large")
							togo.setPizzaSize(3);

						double y = togo.calculateOrderPrice();
						T3.setText(Double.toString(y));//convert the double value to string to Proportional to textField

						Orders.add(new ToGo(T1.getText(), togo.getPizzaSize(), x, toppingPrice));
					}
					if (Rbt2.isSelected()) {
						Seated seated = new Seated();
						int x = seated.getNumOfToppings();
						if (cbox.isSelected())//to check which of the checkBoxes is selected and to set the numOfToppings
							x++;
						if (cbox2.isSelected())
							x++;
						if (cbox3.isSelected())
							x++;
						seated.setNumOfToppings(x);
						seated.setToppingPrice(toppingPrice);
						if (cbo.getValue() == "Small") // to know which of the comboBox selected 
							seated.setPizzaSize(1);
						if (cbo.getValue() == "Medium")
							seated.setPizzaSize(2);
						if (cbo.getValue() == "Large")
							seated.setPizzaSize(3);
						seated.setServiceCharge(service);

						double y = seated.calculateOrderPrice();
						T3.setText(Double.toString(y));

						Orders.add(new Seated(T1.getText(),seated.getPizzaSize() , x,toppingPrice, service));
					}
					if (Rbt3.isSelected()) {
						Delivery delivery = new Delivery();
						int x = delivery.getNumOfToppings();// to check which of the checkBoxes is selected and to set the NumOfToppings
						if (cbox.isSelected())
							x++;
						if (cbox2.isSelected())
							x++;
						if (cbox3.isSelected())
							x++;
						delivery.setNumOfToppings(x);
						delivery.setToppingPrice(toppingPrice);
						if (cbo.getValue() == "Small")
						 	delivery.setPizzaSize(1);
						if (cbo.getValue() == "Medium")
							delivery.setPizzaSize(2);
						if (cbo.getValue() == "Large")
							delivery.setPizzaSize(3);
						delivery.setTipRate(tip);

						double y = delivery.calculateOrderPrice();
						T3.setText(Double.toString(y));
						//add the order to the arrayList 
						Orders.add(new Delivery(T1.getText(),delivery.getPizzaSize() , x, toppingPrice, tip));
					}
					
				}

			} catch ( Exception  e) {   // if the text in textField which is determined above is not double or integer then the alert opened
				Alert alert = new Alert(AlertType.ERROR, "Invalid Input !!!", ButtonType.CLOSE);
				alert.show();
				//throw new InputMismatchException();
			}
		});

		Stage stage2 = new Stage();
		GridPane gpane2 = new GridPane();
		Scene scene2 = new Scene(gpane2, 500, 500);

		File F = new File("ordersfile.txt");
		PrintOrders.setOnAction(e6 -> {

			sortOrders(Orders);// to sort the elements  in the array list descending
			try {
				PrintWriter write=new PrintWriter(F);  // write on the file
			   for(int i=0;i<Orders.size();i++) 
				write.write(Orders.get(i).getName()+"\t\t"+Orders.get(i).calculateOrderPrice()+"\n");
			   int y = 0;
				for (; y < Orders.size();)
					y++;//for rows 
			gpane2.add(new Label(T1.getText() + "\t\t"), 0, y);// print on the stage2
			gpane2.add(new Label(T3.getText()), 1, y++);


			write.close();
			} catch (FileNotFoundException e5) {
				System.out.println("Error in file!!!!!!");
				e5.printStackTrace();
			}
			
			stage2.setTitle("Orders");
			stage2.setScene(scene2);
			stage2.show();
		});

		pane.getChildren().add(gpane);

		Scene scene = new Scene(pane, 1000, 650);
		stage.setTitle("Pizza Order");
		stage.setScene(scene);
		stage.show();
	}
	// this method is to sort the arrayList descending
	private static void sortOrders(ArrayList<PizzaOrder> orders) {
		Collections.sort(orders);
	}

}
