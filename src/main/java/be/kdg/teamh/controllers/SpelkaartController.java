package be.kdg.teamh.controllers;

import be.kdg.teamh.dtos.request.SpelkaartRequest;
import be.kdg.teamh.entities.Kaart;
import be.kdg.teamh.entities.Spelkaart;
import be.kdg.teamh.services.contracts.AuthService;
import be.kdg.teamh.services.contracts.SpelkaartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/spelkaarten")
public class SpelkaartController
{
    private SpelkaartService service;
    private AuthService auth;

    @Autowired
    public SpelkaartController(SpelkaartService service, AuthService auth)
    {
        this.service = service;
        this.auth = auth;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Spelkaart> index()
    {
        return service.all();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void create(@RequestHeader("Authorization") String token, @Valid @RequestBody SpelkaartRequest spelkaart)
    {
        auth.isGeregistreerd(token);

        service.create(spelkaart);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Spelkaart show(@PathVariable("id") int id)
    {
        return service.find(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id, @RequestHeader("Authorization") String token, @Valid @RequestBody SpelkaartRequest kaart)
    {
        auth.isGeregistreerd(token);

        service.update(id, kaart);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id, @RequestHeader("Authorization") String token)
    {
        auth.isGeregistreerd(token);

        service.delete(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/{id}/verschuif", method = RequestMethod.POST)
    public void verschuifKaart(@PathVariable("id") int id, @RequestHeader(name = "Authorization") String token)
    {
        auth.isGeregistreerd(token);

        service.verschuif(id, auth.zoekGebruikerMetToken(token));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "{id}/kaart", method = RequestMethod.GET)
    public Kaart getKaart(@PathVariable("id") int id)
    {
        return service.getKaart(id);
    }
}
