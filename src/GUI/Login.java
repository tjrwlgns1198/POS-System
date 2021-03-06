package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import DAO.Member;
import javax.swing.JPasswordField;

public class Login {
	Member m;

	private JFrame frame;
	private JTextField ID;
	private JPasswordField PWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uD3EC\uC2A4 \uC2DC\uC2A4\uD15C");
		frame.setBounds(100, 100, 393, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton Login = new JButton("\uB85C\uADF8\uC778");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m = new Member();
				int login = m.doLogin(ID.getText(), PWD.getText());
				if (login == 0) {
					new Home();
					frame.setVisible(false);
				} else if (login == 1) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
				} else if (login == 2) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
				}
			}
		});
		Login.setBounds(76, 145, 97, 23);
		frame.getContentPane().add(Login);

		JButton Membership = new JButton("\uD68C\uC6D0\uAC00\uC785");
		Membership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 눌렀을 경우
				new Membership();
				frame.setVisible(false);
			}
		});
		Membership.setBounds(203, 145, 97, 23);
		frame.getContentPane().add(Membership);

		ID = new JTextField();
		ID.setBounds(174, 71, 116, 21);
		frame.getContentPane().add(ID);
		ID.setColumns(10);

		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 72, 66, 18);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(96, 103, 66, 18);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("POS SYSTEM");
		lblNewLabel_2.setFont(new Font("배달의민족 도현", Font.BOLD, 18));
		lblNewLabel_2.setBounds(126, 20, 138, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		PWD = new JPasswordField();
		PWD.setBounds(174, 102, 116, 21);
		frame.getContentPane().add(PWD);
	}
}
