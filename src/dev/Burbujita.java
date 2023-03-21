package dev;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Burbujita extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton sortButton,sortButton2;
    int arr[];

    public Burbujita() {
        // Crear la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(400, 500);

        //Crear el panel principal
        panel = new JPanel(new GridLayout(5, 1));
        
        // Crear la etiqueta y agregarla al panel
        label = new JLabel("Ingrese el total de elementos separados por comas");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);
        
        //Crear el campo de entrada y agregarlo al panel
        inputField = new JTextField(20);
        inputField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(inputField);       
        
        // Crear el área de salida y agregarlo al panel
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        // Crear el botón de ordenamiento y agregarlo al panel
        sortButton = new JButton("Ordenar con burbuja");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Separar();
                
                // Ordenar la lista utilizando el algoritmo Bubble Sort
                bubbleSort(arr);
                
                Mostrar();
            }
        });
        panel.add(sortButton);
        
     // Crear el botón de ordenamiento y agregarlo al panel
        sortButton2 = new JButton("Ordenar con InsertionSort");
        sortButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Separar();
                
                // Ordenar la lista utilizando el algoritmo Bubble Sort
                insertionSort(arr);
                
                Mostrar();
            }
        });
        panel.add(sortButton2);

        // Agregar el panel a la ventana y hacerla visible
        add(panel);
        setVisible(true);
    }
    
    void Mostrar() {
    	 // Mostrar la lista ordenada en el área de salida
        outputArea.setText("");
        for (int i = 0; i < arr.length; i++) {
            outputArea.append(Integer.toString(arr[i]) + " ");
        }
    }
    
    void Separar() {
    	// Obtener la lista de números del campo de entrada
        String input = inputField.getText();
        String[] tokens = input.split(",");
        arr = new int[tokens.length];
        
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i].trim());
        }
    }
    
    // BurbbleSort
    void bubbleSort(int[] arr1) {
        int n = arr1.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        }
    }
    
    // insertion sort
    void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        Burbujita ventana = new Burbujita();
    }
}
