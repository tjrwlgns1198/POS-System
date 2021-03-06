package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.Goods;

public class ErollGoods {

	private JFrame frame;
	private JTextField goodName;
	private JTextField price;
	private JTextField discount;
	private JTextField stockAmount;
	private JTextField ctgName;

	/**
	 * Create the application.
	 */
	public ErollGoods() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uC0C1\uD488\uB4F1\uB85D");
		frame.setBounds(100, 100, 455, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC0C1\uD488 \uB4F1\uB85D");
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 18));
		lblNewLabel.setBounds(177, 24, 87, 29);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBA85");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(64, 64, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("\uAC00\uACA9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(64, 97, 57, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\uD560\uC778\uC728");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(64, 130, 57, 15);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\uC7AC\uACE0\uC218\uB7C9");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(64, 161, 57, 15);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(64, 192, 57, 15);
		frame.getContentPane().add(label_3);

		goodName = new JTextField();
		goodName.setBounds(133, 63, 191, 21);
		frame.getContentPane().add(goodName);
		goodName.setColumns(10);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(133, 94, 191, 21);
		frame.getContentPane().add(price);

		discount = new JTextField();
		discount.setColumns(10);
		discount.setBounds(133, 127, 191, 21);
		frame.getContentPane().add(discount);

		stockAmount = new JTextField();
		stockAmount.setColumns(10);
		stockAmount.setBounds(133, 158, 191, 21);
		frame.getContentPane().add(stockAmount);

		ctgName = new JTextField();
		ctgName.setColumns(10);
		ctgName.setBounds(133, 189, 191, 21);
		frame.getContentPane().add(ctgName);

		JButton save = new JButton("\uC800\uC7A5");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucess = Goods.addGoods(goodName.getText(), price.getText(), stockAmount.getText(),
						discount.getText(), ctgName.getText());
				if (sucess == true) {
					frame.setVisible(false);
					ManageGoods.updateGoods(ctgName.getText());
				} else
					JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다.");

			}
		});
		save.setBounds(95, 220, 97, 23);
		frame.getContentPane().add(save);

		JButton cancle = new JButton("\uCDE8\uC18C");
		cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		cancle.setBounds(238, 220, 97, 23);
		frame.getContentPane().add(cancle);
	}
}
