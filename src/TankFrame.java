import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

    int x = 200, y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED =10;


    public TankFrame(){
        setSize(800,600);//设置大小
        setResizable(true);//可拖动
        setTitle("tank war");//设置标题栏
        setVisible(true);//可视化

        // 创建窗口的监听关闭窗口
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 创建键盘的监听移动坦克
        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g){
        g.fillRect(x,y,40,40);
        switch (dir){
            case LEFT:
                x-=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            default:
                break;
        }
    }

    // 一个匿名类
    class MyKeyListener extends KeyAdapter{
        boolean bL =false;
        boolean bU =false;
        boolean bR =false;
        boolean bD =false;

        @Override
        public void keyPressed(KeyEvent e){
            int key  =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTaqnkDir();
        }

        @Override
        public void keyReleased(KeyEvent e){
            int key  =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTaqnkDir();
        }

        private  void setMainTaqnkDir(){
            if(bL) dir =Dir.LEFT;
            if(bU) dir =Dir.UP;
            if(bR) dir =Dir.RIGHT;
            if(bD) dir =Dir.DOWN;
        }
    }

}
