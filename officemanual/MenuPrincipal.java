/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officemanual;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Sarah
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    //introduccion
    String[] titles_intro = {"ACTIVIDAD", "CHAT", "EQUIPOS", "TAREAS", "CALENDARIO", "LLAMADAS", "ARCHIVOS"};
    String[] descripcion_intro = {"Al seleccionar esta opción se puede\n ver los comentarios \ny respuestas que han hecho los\nmiembros de un equipo o \nllamadas perdidas.",
        "Al seleccionar esta opción\nse puede ver los comentarios\ny respuestas nque han hecho\nlos miembros de un equipo\no llamadas perdidas.",
        "Al seleccionar esta opción\n podremos ver nuestras conversaciones\n con otros miembros del equipo",
        "Se pueden ver todas las tareas\nque se te han asignado.",
        "Crea nuevas reuniones \ncon tiempo anticipado",
        "Llama a cualquier compañero\npara hablar sobre el trabajo.\nEs igual que una llamada\nde teléfono.",
        "Aquí podemos ver los\narchivos utilizados recientemente."};
    String[] link_foto_intro = {"src/officemanual/Fotos/intro1.png",
        "src/officemanual/Fotos/intro2.png",
        "src/officemanual/Fotos/intro3.png",
        "src/officemanual/Fotos/intro4.png",
        "src/officemanual/Fotos/intro5.png",
        "src/officemanual/Fotos/intro6.png",
        "src/officemanual/Fotos/intro7.png"};
    //herramientas
    String[] titles_herramientas = {"Introducción", "Crear una reunión", "Editar reunión", "Cancelar reunión",
        "Asistir a una reunión", "LLAMADAS", "ARCHIVOS"};
    String[] titles_herramientas_icon = {"src/officemanual/Fotos/calendar_1.png",
        "src/officemanual/Fotos/calendar_2.png",
        "src/officemanual/Fotos/calendario.png",
        "src/officemanual/Fotos/icons/new_meeting.png",
        "src/officemanual/Fotos/icons/edit_meeting.png",
        "src/officemanual/Fotos/icons/cancel_meeting.png",
        "src/officemanual/Fotos/intro6.png",
        "src/officemanual/Fotos/intro7.png"};

    String[] link_foto_herramientas = {"src/officemanual/Fotos/calendar_1.png",
        "src/officemanual/Fotos/calendar_2.png",
        "src/officemanual/Fotos/calendar_3.png",
        "src/officemanual/Fotos/calendar_4.png",
        "src/officemanual/Fotos/calendar_5.png",
        "src/officemanual/Fotos/calendar_6.png",
        "src/officemanual/Fotos/calendar_7.png",
        "src/officemanual/Fotos/calendar_8.png",
        "src/officemanual/Fotos/calendar_9.png",
        "src/officemanual/Fotos/calendar_10.png",
        "src/officemanual/Fotos/calendar_11.png",
        "src/officemanual/Fotos/calendar_12.png",
        "src/officemanual/Fotos/calendar_13.png",
        "src/officemanual/Fotos/intro7.png"};

    String[] descripcion_herramientas = {"Aquí se puede ver todas\nlas reuniones pendientes que\ntiene en la semana actual.\n"
        + "\nEn \"SEMANA LABORAL\" puede\n hacer click para cambiar su\nvista a ver la semana\n entera o solamente el día.",
        //COMO CREAR UNA REUNION  1-9
        "Para crear una reunion le\ndamos click al botón\nde \"Nueva reunión\". ",
        "Llenar todos los campos\n1. Título de la reunión\n2. Agregar asistentes\n    mediante agregando su correo\n    o seleccionando su nombre.\n3. Agregar un canal\n4. Agregar ubicación\n5. Escribir mensaje para que\n  les aparezca a los invitados.",
        "Hacer click al botón de guardar.\n\n",
        "Al salir, se verá ingresada la\nreunión en el calendario.\nPor ejemplo, asi como se\n muestra en la imagen.\n\nSe les enviará correo a\ntodos los invitados avisandoles\nsobre la reunión.",
        "Para asistir a la reunión,\ndar click al botón \"unirse\".",
        "Luego, se muestra que tipo\nde audio usar.\nEscoger \"Audio del Equipo\" para\nel audio de la computadora.\n\nLuego, dar click en \"Unirte ahora\".",
        "Puede que le salga esta opción,\nsi es así, solo dar click en\n\"permitir acceso\" para continuar.\n\nSi no sale esta ventanilla, \ncontinue normal. ",
        "Luego aparece la pantalla de\nla llamada.\n\nVerde: encender o apagar tu\n microfóno\n Rojo: encender o apagar la\n cámara\n Azúl: Para compartir pantalla.",
        "Listo,\nya estás en la reunión.",
        //EDITAR REUNION 10-11
        "Para editar una reunión ya\ncreada anteriormente,\nvamos a dar un click a la\nreunión que queremos editar.\n\nEsto abre una ventanilla donde\nestá el botón \"Editar\", \nle damos click ahí.",
        "Siguiente paso, editar cualquier\nopción que queramos.\n\nSe puede añadir y/o eliminar\npersonas y cambiar cualquier\ntipo de campo.\n\nLe damos click a \"Enviar\" para\nguardar los cambios. ",
        //CANCELAR REUNION
        "Para cancelar o eliminar una\nreunión ya creada,\nle damos click derecho a la\nreunión.\n\nLuego se va a abrir una\nventanilla que dice \"Cancelar\", le\nhacemos click y listo, la reunión ha sido borrada. ",
        "",
        ""
    };

    int current_screen_intro = 0, current_screen_herramientas = 0, categoria_num = 0, subcategoria_num = 0, min_slide = 0, max_slide = 0;
    //1 es calendarios.
    int[] opciones_submenu = {0, 1, 2, 3, 4};

    public MenuPrincipal() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void updateInfoIntroduccionInterfaz() {
        String num = current_screen_intro + 1 + ".";
        num_label.setText(num);
        title_label.setText(titles_intro[current_screen_intro]);
        description_label.setText(descripcion_intro[current_screen_intro]);
        photo_label.setIcon(new ImageIcon(new ImageIcon(link_foto_intro[current_screen_intro]).getImage().getScaledInstance(photo_label.getWidth(), photo_label.getHeight(), Image.SCALE_SMOOTH)));
    }

    public void updateInfoHerramientas() {

        //validar si necesita el boton siguiente.
        if (max_slide == current_screen_herramientas) {
            siguiente_b.setVisible(false);
        }else 
            siguiente_b.setVisible(true);

        if (current_screen_herramientas <= max_slide ||  current_screen_herramientas >= min_slide) {
            String num = subcategoria_num + 1 + ".";
            step_number.setText(num);
            step_title.setText(titles_herramientas[subcategoria_num]);//siempre va a ser subcategoria. ese es el title de la categoria.
            step_text.setText(descripcion_herramientas[current_screen_herramientas]);
            step_foto.setIcon(new ImageIcon(new ImageIcon(link_foto_herramientas[current_screen_herramientas]).getImage().getScaledInstance(605, 378, Image.SCALE_SMOOTH)));
        }
    }
    
    public void update_min_and_max_slide(){
        if (categoria_num == 0) {               //CALENDARIOS/REUNIONES
            switch (subcategoria_num) {
                case 0:
                    //INTRODUCCION
                    min_slide = max_slide = 0;
                    break;
                case 1:
                    //CREAR UNA REUNION.
                    min_slide = 1;
                    max_slide = 9;
                    break;
                case 2:
                    //EDITAR UNA REUNION
                    min_slide = 10;
                    max_slide = 11;
                    break;
                case 3:
                    //CANCELAR UNA REUNION
                    min_slide =  max_slide = 12;
                    break;
                default:
                    break;
            }
        }
        current_screen_herramientas = min_slide;
        updateInfoHerramientas();

        Herramientas_2.setModal(true);
        Herramientas_2.pack();
        Herramientas_2.setLocationRelativeTo(null);
        Herramientas_2.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Instalar_MenuPrincipal = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Instalar_Paso3 = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Instalar_Paso4 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Photos_Interfaz = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        photo_label = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        num_label = new javax.swing.JLabel();
        title_label = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        description_label = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        Intro = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        Herramientas = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        Herramientas_2 = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        step_number = new javax.swing.JLabel();
        step_title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        step_text = new javax.swing.JTextArea();
        siguiente_b = new javax.swing.JButton();
        atras_b = new javax.swing.JButton();
        step_foto = new javax.swing.JLabel();
        Opciones_SubMenu = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        actividad6 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        actividad3 = new javax.swing.JLabel();
        actividad5 = new javax.swing.JLabel();
        actividad2 = new javax.swing.JLabel();
        actividad4 = new javax.swing.JLabel();
        actividad1 = new javax.swing.JLabel();
        actividad7 = new javax.swing.JLabel();
        actividad8 = new javax.swing.JLabel();
        t_actividad2 = new javax.swing.JButton();
        t_actividad1 = new javax.swing.JButton();
        t_actividad3 = new javax.swing.JButton();
        t_actividad4 = new javax.swing.JButton();
        t_actividad5 = new javax.swing.JButton();
        t_actividad6 = new javax.swing.JButton();
        t_actividad7 = new javax.swing.JButton();
        t_actividad8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        Instalar_MenuPrincipal.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Instalar_MenuPrincipalWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Primer paso:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ingresar a la página web, dandole click al siguiente enlace: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("https://www.microsoft.com/es-ww/microsoft-teams/download-app#desktopAppDownloadregion");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Segundo paso:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Esperar que la página web cargue, buscar el click al botón de \"Descargar Teams\" y darle click.");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("El botón a buscar se verá así:");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jButton1.setText("Siguiente");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton6.setText("Salir de Instalación");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton6))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout Instalar_MenuPrincipalLayout = new javax.swing.GroupLayout(Instalar_MenuPrincipal.getContentPane());
        Instalar_MenuPrincipal.getContentPane().setLayout(Instalar_MenuPrincipalLayout);
        Instalar_MenuPrincipalLayout.setHorizontalGroup(
            Instalar_MenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        Instalar_MenuPrincipalLayout.setVerticalGroup(
            Instalar_MenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Instalar_Paso3.setMinimumSize(new java.awt.Dimension(943, 468));
        Instalar_Paso3.setResizable(false);
        Instalar_Paso3.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Instalar_Paso3WindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Guardar el archivo en su computadora. ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Se abrirá una ventana parecida a la siguiente en la imagen.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Darle click a \"Guardar\".");

        jButton4.setText("Atrás");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Siguiente");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tercer Paso: ");

        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("NOTA: RECORDAR EN QUE FOLDER SE GUARDA EL ARCHIVO.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                                .addComponent(jButton4)))))
                .addGap(10, 10, 10)
                .addComponent(jButton5)
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout Instalar_Paso3Layout = new javax.swing.GroupLayout(Instalar_Paso3.getContentPane());
        Instalar_Paso3.getContentPane().setLayout(Instalar_Paso3Layout);
        Instalar_Paso3Layout.setHorizontalGroup(
            Instalar_Paso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Instalar_Paso3Layout.setVerticalGroup(
            Instalar_Paso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Instalar_Paso4.setMinimumSize(new java.awt.Dimension(943, 468));
        Instalar_Paso4.setResizable(false);
        Instalar_Paso4.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Instalar_Paso4WindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cuarto Paso: ");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Has instalado Microsoft Teams exitosamente. Click en finalizar para seguir explorando el manual. ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Buscar el folder donde guardaron el archivo y darle click dos veces para abrirlo. ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Luego, la instalación empezará inmediatamente. Cuando termine la instalación se verá así:");

        jButton2.setText("Finalizar Instalación");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("¡Listo!");

        jButton3.setText("Atrás");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 45, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(21, 21, 21))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(333, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Instalar_Paso4Layout = new javax.swing.GroupLayout(Instalar_Paso4.getContentPane());
        Instalar_Paso4.getContentPane().setLayout(Instalar_Paso4Layout);
        Instalar_Paso4Layout.setHorizontalGroup(
            Instalar_Paso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Instalar_Paso4Layout.setVerticalGroup(
            Instalar_Paso4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Photos_Interfaz.setMinimumSize(new java.awt.Dimension(943, 468));
        Photos_Interfaz.setResizable(false);
        Photos_Interfaz.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Photos_InterfazWindowOpened(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Introducción a la interfaz de Microsoft Teams.");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("A continuación podrá ver imagenes sobre las diferentes opciones que tiene Microsoft Teams. ");

        num_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        num_label.setText("1.");

        title_label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        title_label.setText("title");

        jButton7.setText("Siguiente ");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        description_label.setEditable(false);
        description_label.setColumns(20);
        description_label.setRows(5);
        description_label.setAutoscrolls(false);
        jScrollPane1.setViewportView(description_label);

        jButton9.setText("Atrás");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(num_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(photo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7))))))
                    .addComponent(jLabel26)
                    .addComponent(jLabel25))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(num_label)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton9)))
                    .addComponent(photo_label, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout Photos_InterfazLayout = new javax.swing.GroupLayout(Photos_Interfaz.getContentPane());
        Photos_Interfaz.getContentPane().setLayout(Photos_InterfazLayout);
        Photos_InterfazLayout.setHorizontalGroup(
            Photos_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Photos_InterfazLayout.setVerticalGroup(
            Photos_InterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Intro.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                IntroWindowOpened(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setBackground(new java.awt.Color(102, 0, 102));
        jLabel27.setForeground(new java.awt.Color(102, 0, 102));
        jLabel27.setText("                                                                                                                                                    ...cargando...");

        jButton8.setText("Siguiente");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(818, 818, 818)
                .addComponent(jButton8)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );

        javax.swing.GroupLayout IntroLayout = new javax.swing.GroupLayout(Intro.getContentPane());
        Intro.getContentPane().setLayout(IntroLayout);
        IntroLayout.setHorizontalGroup(
            IntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IntroLayout.setVerticalGroup(
            IntroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/grupos.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Calendario:");

        jLabel33.setText("- Como crear reuniones y unirse a ellas");

        jLabel32.setText("- Editar detalles de alguna reunión ya creada");

        jLabel34.setText("- Cancelar alguna reunión ya creada");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/calendario.png"))); // NOI18N
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Equipos/Grupos:");

        jLabel38.setText("- Como crear equipos de trabajo");

        jLabel39.setText("- ¿Qué hacen los Equipos o Grupos?");

        jLabel40.setText("- Como interactuar con el equipo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(320, 320, 320)
                        .addComponent(jLabel37))
                    .addComponent(jLabel32)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(165, 165, 165)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40)
                            .addComponent(jLabel29))))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel40))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HerramientasLayout = new javax.swing.GroupLayout(Herramientas.getContentPane());
        Herramientas.getContentPane().setLayout(HerramientasLayout);
        HerramientasLayout.setHorizontalGroup(
            HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HerramientasLayout.setVerticalGroup(
            HerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Herramientas_2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                Herramientas_2WindowOpened(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        step_number.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        step_number.setText("jLabel32");

        step_title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        step_title.setText("jLabel32");

        step_text.setEditable(false);
        step_text.setColumns(20);
        step_text.setLineWrap(true);
        step_text.setRows(5);
        step_text.setAutoscrolls(false);
        jScrollPane2.setViewportView(step_text);

        siguiente_b.setText("Siguiente");
        siguiente_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguiente_bMouseClicked(evt);
            }
        });

        atras_b.setText("Atrás");
        atras_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atras_bMouseClicked(evt);
            }
        });

        step_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/cargando_sample.png"))); // NOI18N
        step_foto.setText("jLabel36");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(step_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(atras_b)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(siguiente_b)
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(step_number)
                        .addGap(18, 18, 18)
                        .addComponent(step_title, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(step_number, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(step_title, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siguiente_b)
                            .addComponent(atras_b)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(step_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout Herramientas_2Layout = new javax.swing.GroupLayout(Herramientas_2.getContentPane());
        Herramientas_2.getContentPane().setLayout(Herramientas_2Layout);
        Herramientas_2Layout.setHorizontalGroup(
            Herramientas_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Herramientas_2Layout.setVerticalGroup(
            Herramientas_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Opciones_SubMenu.setIconImage(null);
        Opciones_SubMenu.setMaximumSize(new java.awt.Dimension(943, 468));
        Opciones_SubMenu.setMinimumSize(new java.awt.Dimension(943, 468));
        Opciones_SubMenu.setResizable(false);
        Opciones_SubMenu.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                Opciones_SubMenuWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        actividad6.setBackground(new java.awt.Color(102, 255, 255));
        actividad6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("jLabel35");

        actividad3.setBackground(new java.awt.Color(102, 255, 255));
        actividad3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad5.setBackground(new java.awt.Color(102, 255, 255));
        actividad5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad2.setBackground(new java.awt.Color(102, 255, 255));
        actividad2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad4.setBackground(new java.awt.Color(102, 255, 255));
        actividad4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad1.setBackground(new java.awt.Color(102, 255, 255));
        actividad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad7.setBackground(new java.awt.Color(102, 255, 255));
        actividad7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        actividad8.setBackground(new java.awt.Color(102, 255, 255));
        actividad8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que_es_MT.png"))); // NOI18N

        t_actividad2.setText("jButton12");
        t_actividad2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_actividad2MouseClicked(evt);
            }
        });

        t_actividad1.setText("jButton12");
        t_actividad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_actividad1MouseClicked(evt);
            }
        });

        t_actividad3.setText("jButton12");
        t_actividad3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_actividad3MouseClicked(evt);
            }
        });

        t_actividad4.setText("jButton12");
        t_actividad4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_actividad4MouseClicked(evt);
            }
        });

        t_actividad5.setText("jButton12");

        t_actividad6.setText("jButton12");

        t_actividad7.setText("jButton12");

        t_actividad8.setText("jButton12");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(750, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(actividad5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(t_actividad5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(actividad6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(t_actividad2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)))
                            .addComponent(t_actividad6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(actividad3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(actividad7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(t_actividad7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_actividad3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_actividad8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(actividad4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addComponent(t_actividad4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(actividad8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGap(74, 74, 74))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(actividad1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(t_actividad1)
                                .addGap(63, 63, 63)))
                        .addComponent(actividad5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(t_actividad5))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(t_actividad3)
                                        .addGap(63, 63, 63))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(actividad3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)))
                                .addComponent(actividad7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(t_actividad7))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(actividad2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(t_actividad2)
                                .addGap(63, 63, 63)
                                .addComponent(actividad6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(t_actividad6))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(actividad4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(t_actividad4)
                                .addGap(63, 63, 63)
                                .addComponent(actividad8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(t_actividad8)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Opciones_SubMenuLayout = new javax.swing.GroupLayout(Opciones_SubMenu.getContentPane());
        Opciones_SubMenu.getContentPane().setLayout(Opciones_SubMenuLayout);
        Opciones_SubMenuLayout.setHorizontalGroup(
            Opciones_SubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Opciones_SubMenuLayout.setVerticalGroup(
            Opciones_SubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(943, 468));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(943, 468));
        jPanel1.setMinimumSize(new java.awt.Dimension(943, 468));
        jPanel1.setPreferredSize(new java.awt.Dimension(943, 468));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/que es teams.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/instalar teams.png"))); // NOI18N
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/officemanual/Fotos/account teams.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Has click en alguna casilla para comenzar. ");

        jLabel24.setText("(Introducción y descripción)");

        jLabel28.setText("(Guía para descargar e instalar MT.)");

        jLabel30.setText("(Guía para utilizar las herramientas de Microsoft Teams.)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel30)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // go to website
        Desktop browser = Desktop.getDesktop();
        try {
            browser.browse(new URI("https://www.microsoft.com/es-ww/microsoft-teams/download-app#desktopAppDownloadregion"));
        } catch (URISyntaxException err) {
            System.out.println(err);
        } catch (IOException err) {
            System.out.println(err);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void Instalar_MenuPrincipalWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Instalar_MenuPrincipalWindowOpened
        // TODO add your handling code here:
        jLabel10.setIcon(new ImageIcon(new ImageIcon("src/officemanual/Fotos/2paginateams.png").getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_Instalar_MenuPrincipalWindowOpened

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        Instalar_Paso3.setModal(true);
        Instalar_Paso3.pack();
        Instalar_Paso3.setLocationRelativeTo(null);
        Instalar_Paso3.setVisible(true);

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        Instalar_Paso3.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        Instalar_Paso4.setModal(true);
        Instalar_Paso4.pack();
        Instalar_Paso4.setLocationRelativeTo(null);
        Instalar_Paso4.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void Instalar_Paso3WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Instalar_Paso3WindowOpened
        // TODO add your handling code here:
        jLabel22.setIcon(new ImageIcon(new ImageIcon("src/officemanual/Fotos/SaveFileExe.png").getImage().getScaledInstance(jLabel22.getWidth(), jLabel22.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_Instalar_Paso3WindowOpened

    private void Instalar_Paso4WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Instalar_Paso4WindowOpened
        // TODO add your handling code here:
        jLabel18.setIcon(new ImageIcon(new ImageIcon("src/officemanual/Fotos/4paginateams.png").getImage().getScaledInstance(jLabel18.getWidth(), jLabel18.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_Instalar_Paso4WindowOpened

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        Instalar_Paso4.dispose();
        Instalar_Paso3.dispose();
        Instalar_MenuPrincipal.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        Instalar_Paso4.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Instalar_MenuPrincipal.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Photos_InterfazWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Photos_InterfazWindowOpened
        //cargar la primera descripcion de la primer foto y eso.
        current_screen_intro = 0;
        updateInfoIntroduccionInterfaz();
    }//GEN-LAST:event_Photos_InterfazWindowOpened

    private void IntroWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_IntroWindowOpened
        // TODO add your handling code here:
        jLabel27.setIcon(new ImageIcon(new ImageIcon("src/officemanual/Fotos/que_es_MT.png").getImage().getScaledInstance(jLabel27.getWidth(), jLabel27.getHeight(), Image.SCALE_SMOOTH)));
    }//GEN-LAST:event_IntroWindowOpened

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        Photos_Interfaz.setModal(true);
        Photos_Interfaz.pack();
        Photos_Interfaz.setLocationRelativeTo(null);
        Photos_Interfaz.setVisible(true);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        //cambiar info y data de la interfaz SIGUIENTE 
        if (current_screen_intro < 6) {
            current_screen_intro++;
        } else {
            current_screen_intro = 0;
        }
        //actualizar info
        updateInfoIntroduccionInterfaz();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // boton regresar de las fotos de introduccion. ATRAS
        if (current_screen_intro == 0) {
            Photos_Interfaz.dispose();
        } else if (current_screen_intro <= 6) {
            current_screen_intro--;
            //actualizar info
            updateInfoIntroduccionInterfaz();
        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // open jdialog instalar teams.
        Instalar_MenuPrincipal.setModal(true);
        Instalar_MenuPrincipal.pack();
        Instalar_MenuPrincipal.setLocationRelativeTo(null);
        Instalar_MenuPrincipal.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Intro.setModal(true);
        Intro.pack();
        Intro.setLocationRelativeTo(null);
        Intro.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        Herramientas.setModal(true);
        Herramientas.pack();
        Herramientas.setLocationRelativeTo(null);
        Herramientas.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void Herramientas_2WindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Herramientas_2WindowOpened
        //cargar sobre como crear una reunion.
        updateInfoHerramientas();

    }//GEN-LAST:event_Herramientas_2WindowOpened

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        //set a variable que nos avise que cosas cargar.
        categoria_num = 0;

        //abrir las opciones, como el opcion_submenu_actual es 0, van a cargar las imagenes y titulos de calendarios/reuniones.
        Opciones_SubMenu.setModal(true);
        Opciones_SubMenu.pack();
        Opciones_SubMenu.setLocationRelativeTo(null);
        Opciones_SubMenu.setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void siguiente_bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguiente_bMouseClicked
        // siguiente steeep en el calendario
        current_screen_herramientas++;
        updateInfoHerramientas();
    }//GEN-LAST:event_siguiente_bMouseClicked

    private void Opciones_SubMenuWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Opciones_SubMenuWindowGainedFocus
        //CADA VEZ QUE SE ABRA, VA A ACTUALIZAR SU INFORMACION SEGUN EL OPCION_SUBMENU_ACTUAL.
        if (categoria_num == 0) { //ES LA OPCION DE CALENDARIOS/REUNION
            //CARGAR INFO DE CALENDARIOS/REUNION
            jLabel35.setText("CALENDARIOS");
            t_actividad1.setText(titles_herramientas[0]);
            t_actividad2.setText(titles_herramientas[1]);
            t_actividad3.setText(titles_herramientas[2]);
            t_actividad4.setText(titles_herramientas[3]);
            actividad1.setIcon(new ImageIcon(new ImageIcon(titles_herramientas_icon[2]).getImage().getScaledInstance(actividad1.getWidth(), actividad1.getHeight(), Image.SCALE_SMOOTH)));
            actividad2.setIcon(new ImageIcon(new ImageIcon(titles_herramientas_icon[3]).getImage().getScaledInstance(actividad2.getWidth(), actividad2.getHeight(), Image.SCALE_SMOOTH)));
            actividad3.setIcon(new ImageIcon(new ImageIcon(titles_herramientas_icon[4]).getImage().getScaledInstance(actividad3.getWidth(), actividad3.getHeight(), Image.SCALE_SMOOTH)));
            actividad4.setIcon(new ImageIcon(new ImageIcon(titles_herramientas_icon[5]).getImage().getScaledInstance(actividad4.getWidth(), actividad4.getHeight(), Image.SCALE_SMOOTH)));
        }
    }//GEN-LAST:event_Opciones_SubMenuWindowGainedFocus

    private void t_actividad1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_actividad1MouseClicked
        // abrir herramientas 2 solo con las opciones que se pueda.
        //ASIGNARLE UN MINIMO Y MAXIMO SEGUN SU CATEGORIA Y SUBCATEGORIA.
        subcategoria_num = 0;
        update_min_and_max_slide();
    }//GEN-LAST:event_t_actividad1MouseClicked

    private void atras_bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atras_bMouseClicked
        // atras button de herramientas 2
        if (min_slide == current_screen_herramientas)
            Herramientas_2.dispose();
        else
            current_screen_herramientas--;
        updateInfoHerramientas();
    }//GEN-LAST:event_atras_bMouseClicked

    private void t_actividad2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_actividad2MouseClicked
        // TODO add your handling code here:
        subcategoria_num = 1;
        update_min_and_max_slide();
    }//GEN-LAST:event_t_actividad2MouseClicked

    private void t_actividad3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_actividad3MouseClicked
        // TODO add your handling code here:
        subcategoria_num = 2;
        update_min_and_max_slide();
    }//GEN-LAST:event_t_actividad3MouseClicked

    private void t_actividad4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_actividad4MouseClicked
        // TODO add your handling code here:
        subcategoria_num = 3;
        update_min_and_max_slide();
    }//GEN-LAST:event_t_actividad4MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Herramientas;
    private javax.swing.JDialog Herramientas_2;
    private javax.swing.JDialog Instalar_MenuPrincipal;
    private javax.swing.JDialog Instalar_Paso3;
    private javax.swing.JDialog Instalar_Paso4;
    private javax.swing.JDialog Intro;
    private javax.swing.JDialog Opciones_SubMenu;
    private javax.swing.JDialog Photos_Interfaz;
    private javax.swing.JLabel actividad1;
    private javax.swing.JLabel actividad2;
    private javax.swing.JLabel actividad3;
    private javax.swing.JLabel actividad4;
    private javax.swing.JLabel actividad5;
    private javax.swing.JLabel actividad6;
    private javax.swing.JLabel actividad7;
    private javax.swing.JLabel actividad8;
    private javax.swing.JButton atras_b;
    private javax.swing.JTextArea description_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel num_label;
    private javax.swing.JLabel photo_label;
    private javax.swing.JButton siguiente_b;
    private javax.swing.JLabel step_foto;
    private javax.swing.JLabel step_number;
    private javax.swing.JTextArea step_text;
    private javax.swing.JLabel step_title;
    private javax.swing.JButton t_actividad1;
    private javax.swing.JButton t_actividad2;
    private javax.swing.JButton t_actividad3;
    private javax.swing.JButton t_actividad4;
    private javax.swing.JButton t_actividad5;
    private javax.swing.JButton t_actividad6;
    private javax.swing.JButton t_actividad7;
    private javax.swing.JButton t_actividad8;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}
