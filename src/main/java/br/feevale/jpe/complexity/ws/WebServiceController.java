/*
 * Copyright (C) 2019 joaovperin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.complexity.ws;

import br.feevale.jpe.complexity.challenges.Challenge;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * WebService Controller
 *
 * @author joaovperin
 */
@Controller
@RequestMapping("/api")
public class WebServiceController {

    @Autowired
    private List<Challenge> challenges;

    /**
     * Runs a challenge
     *
     * @param challengeNumber
     * @return ResponseEntity
     */
    @GetMapping("/challenge/{challengeNumber}")
    public ResponseEntity challengeOne(@PathVariable final int challengeNumber) {
        // Finds the challenge by it's number
        Challenge challenge = getChallengeByNumber(challengeNumber).
                orElseThrow(() -> new InvalidParameterException("Invalid challenge: " + challengeNumber));
        // Runs the challenge capturing the start and end times
        long start = System.nanoTime();
        Map data = challenge.run();
        long end = System.nanoTime();
        // Creates an answer object with all the data
        StringBuilder sb = new StringBuilder(1024);
        data.forEach((k, v) -> {
            sb.append(k).append("=").append(v).append('\n');
        });
        // Appends the information about the time it took to run
        String answer = sb.append(
                new SimpleDateFormat("ss.SSS").format(new Date(end - start))
        ).toString();
        return ResponseEntity.ok(answer);
    }

    /**
     * Returns the attachments of a challenge (if any)
     *
     * @param challengeNumber
     * @return ResponseEntity
     * @throws IOException
     */
    @GetMapping(
            value = "/challenge/{challengeNumber}/attachment",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody
    byte[] getImageWithMediaType(@PathVariable final int challengeNumber) throws IOException {
        // Finds the challenge by it's number
        Challenge challenge = getChallengeByNumber(challengeNumber).
                orElseThrow(() -> new InvalidParameterException("Invalid challenge: " + challengeNumber));
        InputStream in = getClass().getResourceAsStream("/attachments/" + challenge.attachment());
        return IOUtils.toByteArray(in);
    }

    /**
     * Finds the challenge by it's number
     *
     * @param challengeNumber
     * @return Challenge
     */
    private Optional<Challenge> getChallengeByNumber(final int challengeNumber) {
        return challenges.stream().
                filter(c -> c.number() == challengeNumber).
                findFirst();
    }

}
