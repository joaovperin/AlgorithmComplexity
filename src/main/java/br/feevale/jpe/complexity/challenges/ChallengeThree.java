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
package br.feevale.jpe.complexity.challenges;

import br.feevale.jpe.complexity.utils.Maps;
import br.feevale.jpe.complexity.utils.LongWrapper;
import br.feevale.jpe.complexity.utils.Triangle;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

/**
 * Third challenge
 *
 * @author joaovperin
 */
@Component
public class ChallengeThree implements Challenge {

    /**
     * Returns it's number
     *
     * @return int
     */
    @Override
    public final int number() {
        return 3;
    }

    /**
     * Describes the challenge
     *
     * @return String
     */
    @Override
    public String describe() {
        return new StringBuilder()
                .append("Challenge Three")
                .toString();
    }

    /**
     * Runs the challenge
     *
     * @return Map
     */
    @Override
    public final Map run(Map params) {
        int target = Integer.valueOf(params.getOrDefault("target", 1_000).toString());
        Object answer = myAlgorithm(target);
        return Maps.create()
                .put("target", String.valueOf(target))
                .put("answer", answer.toString())
                .get();

    }

    /**
     * Returns the attachment name of the challenge
     *
     * @return String
     */
    @Override
    public String attachment() {
        return "TerceiroDesafio.pdf";
    }

    /**
     * The algorithm logic
     *
     * @return long
     */
    private Object myAlgorithm(int target) {
        // Creates a new triangle
        LongWrapper answer = new LongWrapper();
        Triangle t = new Triangle();
        IntStream.range(1, target).forEach(x -> t.addLine());
        // Acumulattes all the elements from the stack
        Stack<List<Long>> s = t.getStack();
        while (!s.isEmpty()) {
            s.pop().stream()
                    .filter(n -> (n & 0X1) == 0)
                    .forEach(n -> answer.increment());
        }
        // Format the answer as a string
        return String.format("The answer is: %d.", answer.get());
    }

}
