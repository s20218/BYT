using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    public class Customer : Person
    { 
        public void Send(string msg)
        {
            Console.WriteLine("Customer sends a message: " + msg);
            _mediator.SendMessage(this, msg);
        }

        public void Receive(string msg)
        {
            Console.WriteLine("Customer receives a message: " + msg);
        }
    }
}
