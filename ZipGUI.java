import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ZipGUI {
	
	public String fileName;
	public String zipName;
	public String fileLocation;
	public String zipLocation;
	public String zipFileName;
	JLabel fileLocationLabel;
	JLabel filePathLabel;
	JLabel zipLocationLabel;
	JLabel zipPathLabel;
	
	public ZipGUI() {
		fileLocation = null;
		zipLocation = null;
		fileName = null;
		zipName = null;
		JFrame frame = new JFrame ("File Zipper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(750, 400));
		frame.add(new PositionPane());
		frame.pack();
		frame.setVisible(true);
	}

	protected class PositionPane extends JPanel {
		public PositionPane() {
			GridBagConstraints gbc = new GridBagConstraints();
			
			JPanel filePanel = new JPanel(new GridBagLayout());
			
			fileLocationLabel = new JLabel("File Location");
			filePathLabel = new JLabel("C:\\Program Files\\filePath");
			zipLocationLabel = new JLabel("Zip Location");
			zipPathLabel = new JLabel("C:\\Program Files\\zipPath");
			
			final JButton fileLocationButton = new JButton("Browse File");
			fileLocationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(fileLocationButton);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fc.getCurrentDirectory();
						filePathLabel.setText(fc.getSelectedFile().getPath());
						setFileName(fc.getSelectedFile().getName());
						setFileLocation(selectedFile.getPath());
					}
				}
			});
			
			final JButton zipLocationButton = new JButton("Browse Zip");
			zipLocationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = fc.showOpenDialog(zipLocationButton);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						System.out.println(fc.getSelectedFile().getAbsolutePath());
						zipPathLabel.setText(fc.getSelectedFile().getAbsolutePath());
						setZipName(fc.getSelectedFile().getAbsolutePath());
						setZipLocation(fc.getSelectedFile().getAbsolutePath());
					}
				}
			});
			
			JButton zipButton = new JButton("Zip");
			zipButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String zipFileName = JOptionPane.showInputDialog("Enter the name of the zip file.");
					System.out.println(zipFileName);
					setZipFileName(zipFileName);
					ZipUtil.ZipFile();
				}
			});
			
			//File Components
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.insets = new Insets(0, 0, 20, 150);
			filePanel.add(fileLocationLabel, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.insets = new Insets(0, 0, 0, 120);
			filePanel.add(fileLocationButton, gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.ipadx = 1;
			gbc.insets = new Insets(0, 0, 0, 60);
			filePanel.add(filePathLabel, gbc);
			gbc.ipadx = 0;
			
			//Zip Components
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.insets = new Insets(100, 0, 20, 150);
			filePanel.add(zipLocationLabel, gbc);
			
			gbc.gridx = 0;
			gbc.gridy = 4;
			gbc.insets = new Insets(0, 0, 0, 120);
			filePanel.add(zipLocationButton, gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.ipadx = 2;
			gbc.insets = new Insets(0, 0, 0, 60);
			filePanel.add(zipPathLabel, gbc);
			gbc.ipadx = 0;
			

			gbc.anchor = GridBagConstraints.PAGE_END;
			gbc.insets = new Insets(80, 0, 0, 100);
			gbc.gridx = 0;
			gbc.gridy = 5;
			filePanel.add(zipButton, gbc);
			
			add(filePanel);
			
		}
	}
	public void checkFileNames() {
		JOptionPane.showMessageDialog(null, "File path/name(s) are invalid. Try again.");
	}
	public void showDoneDialog() {
		JOptionPane.showMessageDialog(null, "Done!");
	}
	public void setFileLocation(String file) {
		fileLocation = file;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileName(String file) {
		fileName = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setZipLocation(String file) {
		zipLocation = file;
	}
	public String getZipLocation() {
		return zipLocation;
	}
	public void setZipName(String file) {
		zipName = file;
	}
	public String getZipName() {
		return zipName;
	}
	public void setZipFileName(String file) {
		zipFileName = file;
	}
	public String getZipFileName() {
		return zipFileName;
	}
}
