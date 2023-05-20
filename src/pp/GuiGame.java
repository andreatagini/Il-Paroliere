package pp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import model.Matrice;

public class GuiGame extends JFrame{

    private Matrice metodiMatrice;
    private JScrollPane scrollParole;
    private JPanel panelMain;
    private JPanel panelGrid;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button21;
    private JButton button22;
    private JButton button23;
    private JButton button24;
    private JButton button25;
    private JTextField textBox;
    private JButton button26;
    private JButton button27;
    private JButton button28;
    private JButton button29;
    private JButton button30;
    private JButton button31;
    private JButton button32;
    private JButton button33;
    private JButton button34;
    private JButton button35;
    private JButton button36;
    private JButton button37;
    private JButton button38;
    private JButton button39;
    private JButton button40;
    private JButton button41;
    private JButton button42;
    private JButton button43;
    private JButton button44;
    private JButton button45;
    private JButton button46;
    private JButton button47;
    private JButton button48;
    private JButton button49;
    private JButton button50;
    private JButton button51;
    private JButton button52;
    private JButton button53;
    private JButton button54;
    private JButton button55;
    private JButton button56;
    private JButton button57;
    private JButton button58;
    private JButton button59;
    private JButton button60;
    private JButton button61;
    private JButton button62;
    private JButton button63;
    private JButton button64;
    private JButton button65;
    private JButton button66;
    private JButton button67;
    private JButton button68;
    private JButton button69;
    private JButton button70;
    private JButton button71;
    private JButton button72;
    private JButton button73;
    private JButton button74;
    private JButton button75;
    private JButton button76;
    private JButton button77;
    private JButton button78;
    private JButton button79;
    private JButton button80;
    private JButton button81;
    private JButton button82;
    private JButton button83;
    private JButton button84;
    private JButton button85;
    private JButton button86;
    private JButton button87;
    private JButton button88;
    private JButton button89;
    private JButton button90;
    private JButton button91;
    private JButton button92;
    private JButton button93;
    private JButton button94;
    private JButton button95;
    private JButton button96;
    private JButton button97;
    private JButton button98;
    private JButton button99;
    private JButton button100;
    private JButton btnSend;
    private JButton btnStop;

    private JButton[] bottoni = new JButton[100];

    private String parola;
    private int lastClick;
    private int clicked;

    public GuiGame(GuiMenu2 guimenu) {
        bottoni[0] = button1;
        bottoni[1] = button2;
        bottoni[2] = button3;
        bottoni[3] = button4;
        bottoni[4] = button5;
        bottoni[5] = button6;
        bottoni[6] = button7;
        bottoni[7] = button8;
        bottoni[8] = button9;
        bottoni[9] = button10;
        bottoni[10] = button11;
        bottoni[11] = button12;
        bottoni[12] = button13;
        bottoni[13] = button14;
        bottoni[14] = button15;
        bottoni[15] = button16;
        bottoni[16] = button17;
        bottoni[17] = button18;
        bottoni[18] = button19;
        bottoni[19] = button20;
        bottoni[20] = button21;
        bottoni[21] = button22;
        bottoni[22] = button23;
        bottoni[23] = button24;
        bottoni[24] = button25;
        bottoni[25] = button26;
        bottoni[26] = button27;
        bottoni[27] = button28;
        bottoni[28] = button29;
        bottoni[29] = button30;
        bottoni[30] = button31;
        bottoni[31] = button32;
        bottoni[32] = button33;
        bottoni[33] = button34;
        bottoni[34] = button35;
        bottoni[35] = button36;
        bottoni[36] = button37;
        bottoni[37] = button38;
        bottoni[38] = button39;
        bottoni[39] = button40;
        bottoni[40] = button41;
        bottoni[41] = button42;
        bottoni[42] = button43;
        bottoni[43] = button44;
        bottoni[44] = button45;
        bottoni[45] = button46;
        bottoni[46] = button47;
        bottoni[47] = button48;
        bottoni[48] = button49;
        bottoni[49] = button50;
        bottoni[50] = button51;
        bottoni[51] = button52;
        bottoni[52] = button53;
        bottoni[53] = button54;
        bottoni[54] = button55;
        bottoni[55] = button56;
        bottoni[56] = button57;
        bottoni[57] = button58;
        bottoni[58] = button59;
        bottoni[59] = button60;
        bottoni[60] = button61;
        bottoni[61] = button62;
        bottoni[62] = button63;
        bottoni[63] = button64;
        bottoni[64] = button65;
        bottoni[65] = button66;
        bottoni[66] = button67;
        bottoni[67] = button68;
        bottoni[68] = button69;
        bottoni[69] = button70;
        bottoni[70] = button71;
        bottoni[71] = button72;
        bottoni[72] = button73;
        bottoni[73] = button74;
        bottoni[74] = button75;
        bottoni[75] = button76;
        bottoni[76] = button77;
        bottoni[77] = button78;
        bottoni[78] = button79;
        bottoni[79] = button80;
        bottoni[80] = button81;
        bottoni[81] = button82;
        bottoni[82] = button83;
        bottoni[83] = button84;
        bottoni[84] = button85;
        bottoni[85] = button86;
        bottoni[86] = button87;
        bottoni[87] = button88;
        bottoni[88] = button89;
        bottoni[89] = button90;
        bottoni[90] = button91;
        bottoni[91] = button92;
        bottoni[92] = button93;
        bottoni[93] = button94;
        bottoni[94] = button95;
        bottoni[95] = button96;
        bottoni[96] = button97;
        bottoni[97] = button98;
        bottoni[98] = button99;
        bottoni[99] = button100;

        metodiMatrice = new Matrice();
        parola = "";
        lastClick = -1;

        metodiMatrice.caricaMatrice();
        char[][] matrice = metodiMatrice.getMatrice();
        metodiMatrice.visualMatrice();

        //converto da matrice ad array di char
        // Calcola la dimensione dell'array risultante
        int righe = matrice.length;
        int colonne = matrice[0].length;
        int dimensioneArray = righe * colonne;

        // Crea un nuovo array di char
        char[] array = new char[dimensioneArray];

        // Copia gli elementi della matrice nell'array
        int indice = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                array[indice] = matrice[i][j];
                indice++;
            }
        }

        //btn stop, torna al menu
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guimenu.setVisible(true);
                dispose();
            }
        });

        //controlla se la parola inserita esiste
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean parolaTrovata = false;
                try {
                    parolaTrovata = metodiMatrice.ricercaParolaInMatriceTastiera(parola);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("parola inserita: "+parola);
                System.out.println("esito: "+parolaTrovata);
                System.out.println("");
            }
        });

        for(int i=0; i<bottoni.length; i++) {
            bottoni[i].setText(Character.toString(array[i]));
            bottoni[i].setName(""+i);

            bottoni[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    int posButton = Integer.parseInt(b.getName());

                    //controllo l'ultimo click
                    //se l'ultimo click è a -1, vuol dire che è il primo click
                    //quindi inserisco la parola
                    if(lastClick == -1) {
                        lastClick = posButton;
                        parola = "";
                        parola = parola + b.getText();
                        bottoni[posButton].setEnabled(false);
                    } else {
                        //controllo se il bottone si trova nell'angolo in alto a sinistra
                        if(posButton == 0) {
                            //controllo il click precedente, se non è limitrofo elimino la parola
                            if(lastClick == posButton+1 || lastClick == posButton+10 || lastClick == posButton+11) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //controllo angolo alto a destra
                        } else if(posButton == 9) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton-1 || lastClick == posButton+9 || lastClick == posButton+10) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //controllo angolo basso sinistra
                        } else if (posButton == 90) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton+1 || lastClick == posButton-9 || lastClick == posButton-10) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);
                        } else if (posButton == 99) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton-1 || lastClick == posButton-10 || lastClick == posButton-11) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //controllo riga orizzontale in alto
                        } else if (posButton > 0 && posButton < 9) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton+1 || lastClick == posButton-1 || lastClick == posButton+10 || lastClick == posButton+9 || lastClick == posButton+11) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //controllo riga orizzontale in basso
                        } else if (posButton > 90 && posButton < 99) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton-1 || lastClick == posButton+1 || lastClick == posButton-10 || lastClick == posButton-9 || lastClick == posButton-11) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //controllo riga verticale sinistra - sono tutti divisibili per 10
                        } else if (posButton % 10 == 0) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton+1 || lastClick == posButton-10 || lastClick == posButton+10 || lastClick == posButton-9 || lastClick == posButton+11) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //riga verticale destra - il numero - 9 da un numero divisibile per 10
                        } else if ((posButton-9) % 10 == 0) {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton-1 || lastClick == posButton-10 || lastClick == posButton+10 || lastClick == posButton-11 || lastClick == posButton+9) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);

                            //se è un tasto in mezzo alla griglia
                        } else {
                            //controllo il click precedente se è limitrofo
                            if(lastClick == posButton+1 || lastClick == posButton-1 || lastClick == posButton+10 || lastClick == posButton-10 || lastClick == posButton+11 || lastClick == posButton+9 || lastClick == posButton-11 || lastClick == posButton-9) {
                                parola = parola + b.getText();
                            } else {
                                parola = "";
                                parola = parola +b.getText();
                                abilitaButton();
                            }

                            lastClick = posButton;
                            //disabilito il bottone
                            bottoni[posButton].setEnabled(false);
                        }

                    }

                    //parola = parola + b.getText();
                    textBox.setText(parola);
                    System.out.println(b.getText());
                }
            });
        }
    }

    private String getSTR() {
        Random random = new Random();
        char randomChar = (char) (random.nextInt(26) + 'a');
        String lettera = new String(new char[] {randomChar});

        return lettera;
    }

    //abilita tutti i bottoni
    private void abilitaButton () {
        for(int i=0; i<bottoni.length; i++) {
            bottoni[i].setEnabled(true);
        }
    }

    public String getParola() {
        return parola;
    }

    public JPanel getPanel() {
        return panelMain;
    }
}
