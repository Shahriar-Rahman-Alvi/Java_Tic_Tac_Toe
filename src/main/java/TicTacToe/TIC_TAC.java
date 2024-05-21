/*
 * Tic Tac Toe Game
 * Author: Miftahul Islam Tashfin , Shahriar Rahman 
 * Date: [25/12/2023]
 * Description: [This is a multiplayer Tic Tac Toe java game which we can play 
   using Socket. We have to create a server first and then connect the client 
   from another device.]
 */

package TicTacToe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TIC_TAC extends javax.swing.JFrame {
    
    private static final int PORT = 7517;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private int p1count = 0;
    private int p2count = 0;
    private boolean isServer;
   
    public TIC_TAC(boolean isServer) {
        this.isServer = isServer;
        initComponents();
        if (isServer) {
            initServer();
        } else {
            initClient();
        }
    }
    
    private void initServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for Client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client Connected");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            Thread receiveMovesThread = new Thread(() -> {
                try {
                    while (true) {
                        String move = in.readLine();
                        if (move == null) {
                            break;
                        }
                        int position = Integer.parseInt(move);
                        receiveMove(position);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveMovesThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection();
        }
    }

    private void initClient() {
        try {
            clientSocket = new Socket("localhost", PORT);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            Thread receiveMovesThread = new Thread(() -> {
                try {
                    while (true) {
                        String move = in.readLine();
                        if (move == null) {
                            break;
                        }
                        int position = Integer.parseInt(move);
                        receiveMove(position);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveMovesThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            closeConnection();
        }
    }

    private void sendMove(int position) {
        out.println(position);
    }

    private void receiveMove(int position) {
        java.awt.EventQueue.invokeLater(() -> {
            if (position == -1) {
                resetGame();
            } else {
                setButtonText(position);
            }
        });
    }

    private void closeConnection() {
        try {
            
            if (out != null) {
                out.close();
            }
            
            if (in != null) {
                in.close();
            }
            
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void gameScore()
    {
        p1score.setText(String.valueOf(p1count));
        p2score.setText(String.valueOf(p2count));
    }
    
    private void bActionPerformed(java.awt.event.ActionEvent evt, int position) {
        ButtonAction action = new ButtonAction(position);
        action.actionPerformed(evt);
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        turn = new javax.swing.JLabel();
        p1score = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        player2 = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        p2score = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b1.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 0, 51));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 0, 51));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 0, 51));
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 0, 51));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b5.setForeground(new java.awt.Color(255, 0, 51));
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b6.setForeground(new java.awt.Color(255, 0, 51));
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b7.setForeground(new java.awt.Color(255, 0, 51));
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b8.setForeground(new java.awt.Color(255, 0, 51));
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Comic Sans MS", 1, 70)); // NOI18N
        b9.setForeground(new java.awt.Color(255, 0, 51));
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        turn.setBackground(new java.awt.Color(51, 51, 51));
        turn.setFont(new java.awt.Font("Comic Sans MS", 2, 40)); // NOI18N
        turn.setForeground(new java.awt.Color(255, 0, 0));
        turn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        turn.setText("Player 1's Turn (O)");
        turn.setOpaque(true);

        p1score.setBackground(new java.awt.Color(51, 51, 51));
        p1score.setFont(new java.awt.Font("Impact", 0, 40)); // NOI18N
        p1score.setForeground(new java.awt.Color(255, 0, 0));
        p1score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1score.setText("0");
        p1score.setOpaque(true);

        score.setBackground(new java.awt.Color(204, 204, 204));
        score.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        score.setForeground(new java.awt.Color(102, 0, 204));
        score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score.setText("SCORE");
        score.setOpaque(true);

        exit.setBackground(new java.awt.Color(204, 204, 204));
        exit.setFont(new java.awt.Font("Unispace", 0, 40)); // NOI18N
        exit.setForeground(new java.awt.Color(102, 0, 204));
        exit.setText("EXIT");
        exit.setOpaque(true);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(204, 204, 204));
        reset.setFont(new java.awt.Font("Unispace", 0, 40)); // NOI18N
        reset.setForeground(new java.awt.Color(102, 0, 204));
        reset.setText("RESET");
        reset.setOpaque(true);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        player2.setBackground(new java.awt.Color(204, 204, 204));
        player2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        player2.setForeground(new java.awt.Color(255, 0, 255));
        player2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2.setText("PLAYER 2 (X)");
        player2.setOpaque(true);

        player1.setBackground(new java.awt.Color(204, 204, 204));
        player1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        player1.setForeground(new java.awt.Color(255, 0, 0));
        player1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1.setText("PLAYER 1 (O)");
        player1.setOpaque(true);

        p2score.setBackground(new java.awt.Color(51, 51, 51));
        p2score.setFont(new java.awt.Font("Impact", 0, 40)); // NOI18N
        p2score.setForeground(new java.awt.Color(255, 0, 255));
        p2score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2score.setText("0");
        p2score.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 2, 76)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TIC TAC TOE");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(b4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p1score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(player2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p2score, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
                    .addComponent(turn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p1score, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2score, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        bActionPerformed(evt, 1);
    }//GEN-LAST:event_b2ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        bActionPerformed(evt, 5);
    }//GEN-LAST:event_b6ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        bActionPerformed(evt, 0);
    }//GEN-LAST:event_b1ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        bActionPerformed(evt, 4);
    }//GEN-LAST:event_b5ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        bActionPerformed(evt, 2);
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        bActionPerformed(evt, 3);
    }//GEN-LAST:event_b4ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        bActionPerformed(evt, 6);
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        bActionPerformed(evt, 7);
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        bActionPerformed(evt, 8);
    }//GEN-LAST:event_b9ActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        sendReset();
        resetGame();
    }//GEN-LAST:event_resetActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        
        JFrame frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want Exit",
                "Tic Tac Toe",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
        
    }//GEN-LAST:event_exitActionPerformed

    private void sendReset() {
        out.println("-1");
    }
    
    private void resetGame() {
        
        java.awt.EventQueue.invokeLater(() -> {
            
            b1.setText(null);
            b2.setText(null);
            b3.setText(null);
            b4.setText(null);
            b5.setText(null);
            b6.setText(null);
            b7.setText(null);
            b8.setText(null);
            b9.setText(null);

            for (int i = 0; i < b.length; i++) {
                b[i] = 0;
            }

            enableButtons();

            turn.setText("Player 1's Turn (O)");
            turn.setForeground(Color.RED);

            player_no = 1;
        });
    
    }
    
    private void setButtonText(int position) {
    
        JButton button;
        int flag = 1;
    
        switch (position) {
            case 0:
                button = b1;
                break;
            case 1:
                button = b2;
                break;
            case 2:
                button = b3;
                break;
            case 3:
                button = b4;
                break;
            case 4:
                button = b5;
                break;
            case 5:
                button = b6;
                break;
            case 6:
                button = b7;
                break;
            case 7:
                button = b8;
                break;
            case 8:
                button = b9;
                break;
            default:
                return;
        }

        if (player_no == 1) {
            button.setText("O");
            button.setForeground(Color.RED);
            turn.setText("Player 2's Turn (X)");
            turn.setForeground(Color.MAGENTA);
            b[position] = 1;
            if (CheckWin(1)) {
                JOptionPane.showMessageDialog(null, "Player 2 wins");
                disableButtons();
                p1count++;
                gameScore();
            }
            player_no = 2;
        } else {
            button.setText("X");
            button.setForeground(Color.MAGENTA);
            turn.setText("Player 1's Turn (O)");
            turn.setForeground(Color.RED);
            b[position] = 2;
            
            if (CheckWin(2)) {
                JOptionPane.showMessageDialog(null, "Player 1 wins");
                disableButtons();
                p2count++;
                gameScore();
            }
            
            player_no = 1;
        }
        
        button.setEnabled(false);

        for (int s = 0; s < 9; s++) {
                
            if (b[s] == 0) {
                flag = 0;
                break;
            }
        }

        if (flag == 1 && !CheckWin(1) && !CheckWin(2)) {
            JOptionPane.showMessageDialog(null, "Match has been tied");
            disableButtons();
        }
    
    }
    
    private class ButtonAction implements ActionListener {
    
        private int pos;

        ButtonAction(int position) {
            pos = position;
        }

        public void actionPerformed(ActionEvent e) {
            JButton bx = (JButton) e.getSource();

            if (isServer && player_no == 1) {
                sendMove(pos);
                receiveMove(pos);
                bx.setEnabled(false);
            } else if (!isServer && player_no == 2) {
                sendMove(pos);
                receiveMove(pos);
                bx.setEnabled(false);
            }
        }
    
    }
    
    private void disableButtons() {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    }
    
    private void enableButtons() {
    b1.setEnabled(true);
    b2.setEnabled(true);
    b3.setEnabled(true);
    b4.setEnabled(true);
    b5.setEnabled(true);
    b6.setEnabled(true);
    b7.setEnabled(true);
    b8.setEnabled(true);
    b9.setEnabled(true);
    }

    private boolean CheckWin(int player) {
        
        for (int ml = 0; ml < 7; ml = ml + 3) {
            if (b[ml] == b[ml + 1] && b[ml] == b[ml + 2] && b[ml] == player) {
                return true;
            }
        }

        for (int ml = 0; ml < 3; ml++) {
            if (b[ml] == b[ml + 3] && b[ml] == b[ml + 6] && b[ml] == player) {
                return true;
            }
        }

        for (int ml = 0; ml < 3; ml = ml + 4) {
            if (b[ml] == b[ml + 4] && b[ml] == b[ml + 8] && b[ml] == player) {
                return true;
            }
        }

        for (int ml = 2; ml < 3; ml = ml + 2) {
            if (b[ml] == b[ml + 2] && b[ml] == b[ml + 4] && b[ml] == player) {
                return true;
            }
        }
        return false;
    }


    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TIC_TAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TIC_TAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TIC_TAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TIC_TAC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
        boolean isServer = JOptionPane.showConfirmDialog(null, "Do you want to be the server?", "Server Selection", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        java.awt.EventQueue.invokeLater(() -> {
            new TIC_TAC(isServer).setVisible(true);
        });

        System.out.println("WELCOME TO TIC TAC TOE");
    
    }
    
    int player_no = 1;
    int b[] = new int[9];

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel p1score;
    private javax.swing.JLabel p2score;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JButton reset;
    private javax.swing.JLabel score;
    private javax.swing.JLabel turn;
    // End of variables declaration//GEN-END:variables
}
