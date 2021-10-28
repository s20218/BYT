using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mediator
{
    public abstract class Person
    {
        protected ICheckoutMediator _mediator;

        public Person(ICheckoutMediator mediator = null)
        {
            _mediator = mediator;
        }

        public void SetMediator(ICheckoutMediator mediator)
        {
            _mediator = mediator;
        }
    }
}
