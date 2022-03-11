package com.datarata.datagenerator.api.data;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.naming.SizeLimitExceededException;

import com.datarata.datagenerator.ErrorMessages;
import com.datarata.datagenerator.api.ApiVersion;
import com.datarata.datagenerator.service.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource(value = {"classpath:application.properties"})
@RestController
// @CrossOrigin(origins = {"*"})
@RequestMapping("/data")
public class DataController {


    // @Autowired
    // private EventsDao dao;

    @Autowired
    private DataService dataService;

    /**
     * The get method calls the generateWords method from the service to generate random text
     *
     * @param numberOfWords the id of the user to fetch
     * @return random words of the requested length.
     * @throws SizeLimitExceededException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    @GetMapping("char/{size}")
    @ApiVersion(from = 0.1, to = 0.2)
    public String getChar(@PathVariable int size) throws SizeLimitExceededException, NoSuchAlgorithmException, IOException {
        if (size > 255) {
            throw new SizeLimitExceededException(ErrorMessages.SIZE_LIMIT_EXCEED);
        }
        return this.dataService.generateWord(size);
    }

    // @GetMapping("/getAllEvents")
    // public List<Events> getAllEvents() {
    //     return dao.getAllEvents();
    // }


    // @GetMapping("/getEvents")
    // public List<Events> getEvents(@RequestParam(defaultValue = "0") Integer pageNo,
    //                               @RequestParam(defaultValue = "10") Integer pageSize,
    //                               @RequestParam(defaultValue = "empty") String eventStartDate,
    //                               @RequestParam(defaultValue = "empty") String eventEndDate,
    //                               @RequestParam(defaultValue = "eventName") String sortBy) {
    //     if(eventStartDate.equals("empty")){
    //         return dao.getEvents(pageNo, pageSize, sortBy);
    //     }
    //     return dao.getEvents(pageNo, pageSize, eventStartDate, eventEndDate, sortBy);
    // }


    // @PostMapping ("/scrapeEvents")
    // public String scrapeEvents(@RequestBody Urls urls) {
    //     List<Events> eventList= service.scrapingEvents(urls.getUrls());
    //     return dao.saveEventList(eventList);
    // }
}
