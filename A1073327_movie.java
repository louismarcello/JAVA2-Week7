import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class movie extends JFrame implements ActionListener,ItemListener{

    String[] movies = {"Wakanda Forever", "Avatar 2", "Ant Man", "Avenger"};
    JLabel notice = new JLabel("add and delete movie");

    JComboBox<String> selection = new JComboBox<>(movies);
    JButton add, delete;

    movie(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Movie Theater");
        setBounds(500, 200, 400, 300);
        setLayout(null);
        
        JPanel movie = new JPanel();
        add(movie);
        movie.setBounds(0,0,430,70);
        movie.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel title = new JLabel("Movie name: ");
        movie.add(title);
        title.setBounds(10,10,20,15);

        movie.add(selection);
        selection.addItemListener(this);

        JPanel displayPane = new JPanel();
        add(displayPane);
        displayPane.setBounds(0, 180, 430, 50);
        displayPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        displayPane.add(notice);
        notice.setBounds(5, 10, 80, 15);

        JPanel operation = new JPanel();
        add(operation);
        operation.setBounds(0, 80, 430, 90);
        operation.setLayout(new FlowLayout(FlowLayout.RIGHT));     
        
        add = new JButton("Add");
        add.setBounds(100, 10, 50, 30);
        add.addActionListener(this);
        operation.add(add);
        
        delete = new JButton("Delete");
        delete.setBounds(100, 100, 50, 30);
        operation.add(delete);
        delete.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == add){
            String newMovie = JOptionPane.showInputDialog("Please enter movie name");
            selection.addItem(newMovie);
            notice.setText("Added " +newMovie+ " to the collection");
        }

        if (e.getSource() == delete){
            Object selected = selection.getSelectedItem();
            selection.removeItem(selected);
            notice.setText("Deleted " +selected+ ".");
        }
    }

    public void itemStateChanged(ItemEvent e){
        Object show = selection.getSelectedItem();
        int index = selection.getSelectedIndex();
        notice.setText(show+ ", index = " +index);
    }
}

public class A1073327_movie{
    public static void main(String[] args){
        movie frame = new movie();
    }
}