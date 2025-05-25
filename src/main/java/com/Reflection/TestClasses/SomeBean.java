package com.Reflection.TestClasses;

import com.Reflection.AutoInjectable;

public class SomeBean {
        @AutoInjectable
        private SomeInterface field1;
        @AutoInjectable
        private SomeOtherInterface field2;
        public String foo(){
            return field1.doSomething() + field2.doSomeOther();
        }
        public String foo2(){
                return field1.doSomething2() + field2.doSomeOther();
        }
}
