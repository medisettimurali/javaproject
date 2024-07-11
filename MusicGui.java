package musicapp; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MusicGui implements ActionListener, ListSelectionListener{
	private NodeTest N;
	MusicGui(NodeTest N){
		this.N=N;
	}
	JFrame f;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JLabel jl1,jl2,jl3,jl4,jl5;
	JLabel jc1,jc2,jc3,jc4;
	DefaultListModel<String> listModel;
	JList<String> musicList;
	JPanel leftPanel;
	JPanel rp;
	JScrollPane musicListScrollPane;
	public void ShowGui(){
		f=new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setSize(1600,900);
		listModel = new DefaultListModel<>();
		for(String name:N.sName) {
			listModel.addElement(name);
		}
		musicList = new JList<>(listModel);
        musicListScrollPane = new JScrollPane(musicList);
        musicList.setBackground(Color.black);
        musicList.setForeground(Color.WHITE);
        musicList.setSelectionForeground(Color.BLACK);
        musicList.setSelectionBackground(Color.WHITE);
		leftPanel = new JPanel(new BorderLayout());
        rp = new JPanel();
        musicList.setFixedCellWidth(200); 
        musicList.setCellRenderer(new DefaultListCellRenderer() {
            { setHorizontalAlignment(SwingConstants.CENTER); } 
        });
        leftPanel.add(musicListScrollPane, BorderLayout.CENTER);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,4)); 
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE,4));
        rp.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));
        rp.setLayout(null);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rp);
        splitPane.setDividerLocation(0.1);
        splitPane.setDividerSize(0);
        splitPane.setResizeWeight(0.1);
        splitPane.setEnabled(false);
        splitPane.setOneTouchExpandable(false);
        splitPane.setDividerSize(5);
        f.add(splitPane);
		jb1 = new JButton("PREVIOUS");
		jb2 = new JButton("PLAY");
		jb3 = new JButton("NEXT");
		jb4 = new JButton("ADD SONG");
		jb5 = new JButton("DELETE SONG");
		jb6 = new JButton("RENAME SONG");
		jc1 = new JLabel("SONG NAME:");
		jc2 = new JLabel("MOVIE NAME:");
		jc3 = new JLabel("YEAR:");
		jc4 = new JLabel("LYRICS:");
		jl1 = new JLabel("GABBARSINGH");
		jl2 = new JLabel("GABBAR SINGH");
		jl3 = new JLabel("2012");
		jl4 = new JLabel("NO LYRICS FOUND");
		jl5 = new JLabel("MUSIC PLAYER");
		rp.add(jc1);
		rp.add(jc2);
		rp.add(jc3);
		rp.add(jc4);
		rp.add(jl1);
		rp.add(jl2);
		rp.add(jl3);
		rp.add(jl4);
		rp.add(jb1);
		rp.add(jb2);
		rp.add(jb3);
		rp.add(jb4);
		rp.add(jb5);
		rp.add(jb6);
		rp.add(jl5);
		jc1.setBounds(250,250,180,30);
		jl1.setBounds(450,250,250,30);
		jc2.setBounds(250,290,250,30);
		jl2.setBounds(450,290,250,30);
		jc3.setBounds(250,330,250,30);
		jl3.setBounds(450,330,250,30);
		jc4.setBounds(250,370,250,30);
		jl4.setBounds(450,370,250,30);
		jb1.setBounds(200,450,120,50);
		jb2.setBounds(350,450,120,50);
		jb3.setBounds(500,450,120,50);
		jb4.setBounds(700,250,120,50);
		jb5.setBounds(700,350,120,50);
		jb6.setBounds(700,450,120,50);
		jl5.setBounds(300,50,420,100);
	    jb1.setBackground(Color.BLACK);
	    jb1.setForeground(Color.WHITE);
	    jb2.setBackground(Color.BLACK);
	    jb2.setForeground(Color.WHITE);
	    jb3.setBackground(Color.BLACK);
	    jb3.setForeground(Color.WHITE);
	    jb4.setBackground(Color.BLACK);
	    jb4.setForeground(Color.WHITE);
	    jb5.setBackground(Color.BLACK);
	    jb5.setForeground(Color.WHITE);
	    jb6.setBackground(Color.BLACK);
	    jb6.setForeground(Color.WHITE);
		musicList.setFont(new Font("Roboto", Font.BOLD, 25));
		jc1.setFont(new Font("Roboto", Font.BOLD, 20));
		jl1.setFont(new Font("Roboto", Font.BOLD|Font.ITALIC, 20));
		jc2.setFont(new Font("Roboto",Font.BOLD, 20));
		jl2.setFont(new Font("Roboto",Font.BOLD|Font.ITALIC, 20));
		jc3.setFont(new Font("Roboto",Font.BOLD, 20));
		jl3.setFont(new Font("Roboto",Font.BOLD|Font.ITALIC, 20));
		jc4.setFont(new Font("Roboto",Font.BOLD, 20));
		jl4.setFont(new Font("Roboto",Font.BOLD|Font.ITALIC, 20));
		jl5.setFont(new Font("Roboto",Font.BOLD|Font.ITALIC,50));
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		musicList.addListSelectionListener(this);
		N.defaultSongs();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				NodeTest N = new NodeTest();
				MusicGui musicgui = new MusicGui(N);
				musicgui.ShowGui();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb2) {
			if(jb2.getText()=="PLAY") {
				jb2.setText("PAUSE");
			}else {
				jb2.setText("PLAY");
			}
		}
		else if(e.getSource()==jb3) {
			String s1=jl1.getText();
			Node result=N.Next(s1);
			jl1.setText(""+result.getSongName());
			jl2.setText(""+result.getMovieName());
			jl3.setText(""+result.getYear());
		}
		else if(e.getSource()==jb1) {
			String s1=jl1.getText();
			Node result=N.Previous(s1);
			jl1.setText(""+result.getSongName());
			jl2.setText(""+result.getMovieName());
			jl3.setText(""+result.getYear());
		}
		else if(e.getSource()==jb4) {
			String songName=N.addNode();
			listModel.addElement(songName);
			musicList.revalidate();
			musicList.repaint();
		}
		else if(e.getSource()==jb5) {
			String songName=N.delete();
			listModel.removeElement(songName);;
			musicList.revalidate();
			musicList.repaint();
		}
		else if(e.getSource()==jb6) {
			String s3=N.RenameSong();
			String s2=N.songName;
			int x=listModel.indexOf(s2);
			listModel.remove(x);
			listModel.add(x,s3);
			musicList.revalidate();
			musicList.repaint();
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
            int selectedIndex = musicList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedItem = listModel.getElementAt(selectedIndex);
                Node result=N.Play(selectedItem);
    			jl1.setText(""+result.getSongName());
    			jl2.setText(""+result.getMovieName());
    			jl3.setText(""+result.getYear());
            }
        }
	}
	
}
