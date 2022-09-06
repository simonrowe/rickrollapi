package com.global.rickrollapi;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@SpringBootApplication
@RestController
public class RickrollapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickrollapiApplication.class, args);
    }

    @GetMapping(value = "/rickroll/{numberOfSeconds}", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> add(@PathVariable final int numberOfSeconds) {
        return Flux.create((emitter) -> lyrics(emitter, numberOfSeconds));
    }

    private void lyrics(final FluxSink<String> emitter, final int numberOfSeconds) {
        final List<Lyric> lyrics = Lyric.allLyrics();
        for (int i = 0; i < lyrics.size(); i++) {
            Lyric current = lyrics.get(i);
            emitter.next(current.getLyric());
            if (i < lyrics.size() - 1) {
                Lyric next = lyrics.get(i + 1);
                if (numberOfSeconds < next.getStartSecond()) {
                    break;
                }
                try {
                    Long pauseSpace = (long) (next.getStartSecond() - current.getStartSecond()) * 1000;
                    Thread.sleep(pauseSpace);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        emitter.complete();
    }


}

class Lyric {

    private int startSecond;
    private String lyric;

    public Lyric(final int startSecond, final String lyric) {
        this.startSecond = startSecond;
        this.lyric = lyric;
    }

    public int getStartSecond() {
        return startSecond;
    }

    public void setStartSecond(final int startSecond) {
        this.startSecond = startSecond;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(final String lyric) {
        this.lyric = lyric;
    }

    public static List<Lyric> allLyrics() {
        final List<Lyric> lyrics = new ArrayList<>();
        lyrics.add(new Lyric(0, "Intro (Ginger Hair & Foot Tapping)"));
        lyrics.add(new Lyric(5, "Intro (Arm Flapping & Cut to Night Scene)"));
        lyrics.add(new Lyric(10, "Intro (Lady Dancing)"));
        lyrics.add(new Lyric(12, "Intro (Sunglasses by the Fence)"));
        lyrics.add(new Lyric(15, "Intro (Lady Dancing - Again - This time facing the wrong way)"));
        lyrics.add(new Lyric(17, "Intro Finished"));
        lyrics.add(new Lyric(18, "We're no strangers to love"));
        lyrics.add(new Lyric(22, "You know the rules and so do I (do I)"));
        lyrics.add(new Lyric(27, "A full commitment's what I'm thinking of"));
        lyrics.add(new Lyric(31, "You wouldn't get this from any other guy"));
        lyrics.add(new Lyric(34, "I just wanna tell you how I'm feeling"));
        lyrics.add(new Lyric(40, "Gotta make you understand"));
        lyrics.add(new Lyric(43, "Never gonna give you up"));
        lyrics.add(new Lyric(46, "Never gonna let you down"));
        lyrics.add(new Lyric(48, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(52, "Never gonna make you cry"));
        lyrics.add(new Lyric(54, "Never gonna say goodbye"));
        lyrics.add(new Lyric(55, "Never gonna tell a lie and hurt you"));
        lyrics.add(new Lyric(61, "We've known each other for so long"));
        lyrics.add(new Lyric(65, "Your heart's been aching, but you're too shy to say it (say it)"));
        lyrics.add(new Lyric(69, "Inside, we both know what's been going on (going on)"));
        lyrics.add(new Lyric(73, "We know the game and we're gonna play it"));
        lyrics.add(new Lyric(77, "And if you ask me how I'm feeling"));
        lyrics.add(new Lyric(82, "Don't tell me you're too blind to see"));
        lyrics.add(new Lyric(85, "Never gonna give you up"));
        lyrics.add(new Lyric(87, "Never gonna let you down"));
        lyrics.add(new Lyric(89, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(94, "Never gonna make you cry"));
        lyrics.add(new Lyric(96, "Never gonna say goodbye"));
        lyrics.add(new Lyric(99, "Never gonna tell a lie and hurt you"));
        lyrics.add(new Lyric(102, "Never gonna give you up"));
        lyrics.add(new Lyric(105, "Never gonna let you down"));
        lyrics.add(new Lyric(107, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(110, "Never gonna make you cry"));
        lyrics.add(new Lyric(112, "Never gonna say goodbye"));
        lyrics.add(new Lyric(115, "Never gonna tell a lie and hurt you"));
        lyrics.add(new Lyric(129, "Never gonna give, never gonna give"));
        lyrics.add(new Lyric(133, "Never gonna give, never gonna give"));
        lyrics.add(new Lyric(136, "We've known each other for so long"));
        lyrics.add(new Lyric(141, "Your heart's been aching, but you're too shy to say it (say it)"));
        lyrics.add(new Lyric(145, "Inside, we both know what's been going on (going on)"));
        lyrics.add(new Lyric(149, "We know the game and we're gonna play it"));
        lyrics.add(new Lyric(153, "I just wanna tell you how I'm feeling"));
        lyrics.add(new Lyric(160, "Gotta make you understand"));
        lyrics.add(new Lyric(161, "Never gonna give you up"));
        lyrics.add(new Lyric(163, "Never gonna let you down"));
        lyrics.add(new Lyric(167, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(170, "Never gonna make you cry"));
        lyrics.add(new Lyric(173, "Never gonna say goodbye"));
        lyrics.add(new Lyric(175, "Never gonna tell a lie and hurt you"));
        lyrics.add(new Lyric(179, "Never gonna give you up"));
        lyrics.add(new Lyric(181, "Never gonna let you down"));
        lyrics.add(new Lyric(183, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(188, "Never gonna make you cry"));
        lyrics.add(new Lyric(190, "Never gonna say goodbye"));
        lyrics.add(new Lyric(192, "Never gonna tell a lie and hurt you"));
        lyrics.add(new Lyric(196, "Never gonna give you up"));
        lyrics.add(new Lyric(198, "Never gonna let you down"));
        lyrics.add(new Lyric(210, "Never gonna run around and desert you"));
        lyrics.add(new Lyric(214, "Never gonna make you cry"));
        lyrics.add(new Lyric(217, "Never gonna say goodbye"));
        lyrics.add(new Lyric(219, "Never gonna tell a lie and hurt you"));
        return lyrics;
    }

}