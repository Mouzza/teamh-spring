package be.kdg.teamh.exceptions.gebruiker;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class GebruikerIsReedsDeelnemer extends RuntimeException
{
    //
}
