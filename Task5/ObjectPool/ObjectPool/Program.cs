using System;

namespace ObjectPool
{
    class Program
    {
        public static void Main(string[] args)
        {
            var pool = Pool.Instance;

            pool.SetMaxSize(1);

            var obj1 = pool.GetObject();
            var obj2 = pool.GetObject();            

            pool.ReturnObject(obj2);

            var obj3 = pool.GetObject();
            
        }
    }
}
