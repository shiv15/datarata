package com.datarata.datagenerator.api.data;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.naming.SizeLimitExceededException;

import com.datarata.datagenerator.ErrorMessages;
import com.datarata.datagenerator.api.ApiVersion;
import com.datarata.datagenerator.service.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource(value = {"classpath:application.properties"})
@RestController
@RequestMapping("/data")
public class DataController {

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
    public String getChar(@PathVariable int size) throws SizeLimitExceededException, IOException {
        if (size > 255) {
            throw new SizeLimitExceededException(ErrorMessages.SIZE_LIMIT_EXCEED);
        }
        return this.dataService.generateWord(size);
    }
}
