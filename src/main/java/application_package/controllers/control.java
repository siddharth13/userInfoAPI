package application_package.controllers;


import application_package.model.Users;
import application_package.model.node;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
 class Control {
    private List<node> list =new ArrayList<>();
    private AtomicLong id=new AtomicLong();
    @PostMapping("/")
    public String Home(){
        String string="Welcome to the First Page."+"\n"+"endpoints=>"+"\n"+"insert: POST for inserting data"+"\n"+"getdata: GET for recieving User Data";
        return string;
    }
    @PostMapping("/insert")
    public void putNode(@RequestBody node n){
        list.add(n);
    }
    @PostMapping("/insertusers")
    public void putUsers(@RequestBody Users users){

    }

    @GetMapping("/getdata")
    public ResponseEntity<?> getData(){
       String str=new String();
        for(int i=0;i<list.size();i++){
            node n=list.get(i);
            String t=n.getTitle();
            String d=n.getDescription();
            str=str+t+" : "+d+":::::::::::::";
        }
        return ResponseEntity.ok(list);
    }

}
