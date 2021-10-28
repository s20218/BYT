using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Multiply : IChain
    {
        private IChain _nextInChain;

        public void calculate(Numbers request)
        {
            if (request.getOperation() == "mult" || request.getOperation() == "*")
            {
                int num1 = request.getNumber1();
                int num2 = request.getNumber2();
                int mult = num1 * num2;
                Console.WriteLine(num1 + " * " + num2 + " = " + mult);
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
