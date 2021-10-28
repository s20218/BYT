using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public interface IChain
    {
        public void setNextChain(IChain nextInChain);

        public void calculate(Numbers request);
    }
}
