package tech.donau.course.service;


import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingService {
    fun greetIt(name: String) = "Hi $name"
}