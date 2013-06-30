/*
 * Copyright 2013 Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark.template.velocity.example;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityRoute;

/**
 * VelocityTemplateRoute example.
 */
public final class VelocityExample {
    public static void main(final String[] args) {
        
        get(new VelocityRoute("/hello") {
            @Override
            public Object handle(final Request request, final Response response) {
                Map<String, Object> model = new HashMap<>();
                model.put("hello", "Velocity World");
                model.put("person", new Person("Foobar"));
                
                // The wm files are located under the resources directory
                return modelAndView(model, "hello.wm");
            }
        });
        
    }
    
    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
}