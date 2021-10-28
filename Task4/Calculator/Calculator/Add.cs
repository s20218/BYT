using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Add : IChain
    {
        private IChain _nextInChain;

        public void calculate(Numbers request)
        {
            if(request.getOperation() == "add" || request.getOperation() == "+")
            {
                int num1 = request.getNumber1();
                int num2 = request.getNumber2();
                int sum = num1 + num2;
                Console.WriteLine(num1 + " + " + num2 + " = " + sum);
            }
            else
            {
                _nextInChain.calculate(request);
            }
        }

        public void setNextChain(IChain nextInChain)
        {
            _nextInChain = nextInChain;
        }
    }
}
