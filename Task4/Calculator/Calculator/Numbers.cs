using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Numbers
    {
        private int _number1;
        private int _number2;

        private string _operation;

        public Numbers(int number1, int number2, string operation)
        {
            _number1 = number1;
            _number2 = number2;
            _operation = operation;
        }

        public int getNumber1() { return _number1; }
        public int getNumber2() { return _number2; }
        public string getOperation() { return _operation; }
    }
}
