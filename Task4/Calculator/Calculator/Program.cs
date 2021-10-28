using System;

namespace Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            IChain chainOperation1 = new Add();
            IChain chainOperation2 = new Substract();
            IChain chainOperation3 = new Multiply();
            IChain chainOperation4 = new Divide();

            chainOperation1.setNextChain(chainOperation2);
            chainOperation2.setNextChain(chainOperation3);
            chainOperation3.setNextChain(chainOperation4);

            Numbers request = new Numbers(5, 3, "div");

            chainOperation1.calculate(request);

        }
    }
}
