package com.server.seb41_main_11.domain.program.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int userMax;

    private int userCount = 0;

    private int cost;

    private String image;

    private String announce;

    private String zoomLink;

    @Column(nullable = false)
    private String dateStart;

    @Column(nullable = false)
    private String dateEnd;

    @Builder
    public Program(Long programId, String title, String content, int userMax, int userCount,
        int cost,
        String image, String announce, String zoomLink, String dateStart, String dateEnd) {
        this.programId = programId;
        this.title = title;
        this.content = content;
        this.userMax = userMax;
        this.userCount = userCount;
        this.cost = cost;
        this.image = image;
        this.announce = announce;
        this.zoomLink = zoomLink;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public static Program of(Program program) {
        return Program.builder()
            .programId(program.getProgramId())
            .title(program.getTitle())
            .content(program.getContent())
            .userMax(program.getUserMax())
            .userCount(program.userCount)
            .cost(program.getCost())
            .image(program.getImage())
            .announce(program.getAnnounce())
            .zoomLink(program.getZoomLink())
            .dateStart(program.getDateStart())
            .dateEnd(program.getDateEnd())
            .build();
    }
}