package com.example.tpspring.service;

import com.example.tpspring.Repositories.ClientReppositories;
import com.example.tpspring.entites.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientReppositories clientReppositories;
    public Client saveClient(Client client){
        return  clientReppositories.save(client);

    }

    public List<Client> getAll(){
        return  (List<Client>) clientReppositories.findAll();
    }

    public Client getClientById(int id){
        return clientReppositories.findById(id).orElseThrow(()->new IllegalArgumentException("Client id not found"));

    }
    @PostConstruct
    private void addClientsToDB(){
        if(clientReppositories.count()==0){
            saveClient(new Client("12345678","Doe","John","NY"));
            saveClient(new Client("12345679","Doe","Jane","Cal"));
        }
    }






   /* @Autowired itha bach testa3mel autowried
    public ClientService(ClientReppositories clientReppositories1){
        this.clientReppositories= clientReppositories1;
    }*/

}
