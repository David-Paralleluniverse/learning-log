using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Circleapp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string r = textBox1.Text;
            double r1 = Convert.ToDouble(r);
            double c = r1 * 2 * 3.14;
            double s=r1*r1*3.14;
            if (r1 <= 0) 
            {
                label2.Text = "无效值";
                label4.Text = "请重新检查数值！";
            }
            else
            {
                label2.Text = c.ToString();
                label4.Text = s.ToString();
            }
            
            
              


        }

        private void button2_Click(object sender, EventArgs e)
        {
            System.Environment.Exit(0);
        }
    }
}
