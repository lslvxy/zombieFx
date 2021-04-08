package com.pz.window;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import com.pz.util.GameUtil;
import com.pz.util.UserBean;

public class RankPanel extends AnchorPane {

	private ImageView sureImage = new ImageView(GameUtil.sureImage);
	private TableView<UserBean> table = new TableView<UserBean>();

	public RankPanel(MainFrame mainFrame) {
		setVisible(false);
		ImageView rankListImage = new ImageView(GameUtil.rankListImage);
		sureImage.setLayoutX(35);
		sureImage.setLayoutY(380);
		Text sureText = new Text("确定");
		sureText.setFont(Font.font("宋体", FontWeight.BOLD, 50));
		sureText.setFill(Color.GREEN);
		sureText.setLayoutX(160);
		sureText.setLayoutY(440);

		sureImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setVisible(false);
			}
		});
		sureText.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setVisible(false);
			}
		});
		table.setLayoutX(100);
		table.setLayoutY(110);
		table.setMaxHeight(230);
		table.setMaxWidth(230);
		TableColumn<UserBean, String> first = new TableColumn<UserBean, String>(
				"姓名");
		first.setMinWidth(100);
		first.setSortable(false);
		first.setResizable(false);
		first.setCellValueFactory(new PropertyValueFactory<UserBean, String>(
				"userName"));

		TableColumn<UserBean, String> last = new TableColumn<UserBean, String>(
				"分数");
		last.setMinWidth(100);
		last.setResizable(false);
		last.setCellValueFactory(new PropertyValueFactory<UserBean, String>(
				"score"));
		table.getColumns().addAll(first, last);

		this.getChildren().addAll(rankListImage, sureImage, sureText, table);

	}

	public ImageView getSureImage() {
		return sureImage;
	}

	public void setSureImage(ImageView sureImage) {
		this.sureImage = sureImage;
	}

	public TableView<UserBean> getTable() {
		return table;
	}

	public void setTable(TableView<UserBean> table) {
		this.table = table;
	}

}
