using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    public class Cashier : Person
    {
        public void Send(string msg)
        {
            Console.WriteLine("Cashier sends a message: " + msg);
            _mediator.SendMessage(this, msg);
        }

        public void Receive(string msg)
        {
            Console.WriteLine("Cashier receives a message: " + msg);
        }
    }
}
