using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Divide : IChain
    {
        private IChain _nextInChain;

        public void calculate(Numbers request)
        {
            if (request.getOperation() == "div" || request.getOperation() == "/")
            {
                double num1 = request.getNumber1();
                double num2 = request.getNumber2();
                double div = num1 / num2;
                Console.WriteLine(num1 + " / " + num2 + " = " + div);
            }
            else
            {
                Console.WriteLine("The operation is not supported.");
            }
        }

        public void setNextChain(IChain nextInChain)
        {
            _nextInChain = nextInChain;
        }
    }
}
