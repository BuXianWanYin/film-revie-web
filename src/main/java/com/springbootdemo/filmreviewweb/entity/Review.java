package com.springbootdemo.filmreviewweb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

/**
 * 观后感实体类
 */
@TableName("review")
public class Review {
    
    @TableId(type = IdType.AUTO)
    private Long id;
    
    private Long userId;
    
    private String movieTitle;
    
    private String movieDesc;
    
    private String moviePoster;
    
    private String reason;
    
    private String plotAnalysis;
    
    private String characterAnalysis;
    
    private String impression;
    
    private String professionalThinking;
    
    private String summary;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(String moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPlotAnalysis() {
        return plotAnalysis;
    }

    public void setPlotAnalysis(String plotAnalysis) {
        this.plotAnalysis = plotAnalysis;
    }

    public String getCharacterAnalysis() {
        return characterAnalysis;
    }

    public void setCharacterAnalysis(String characterAnalysis) {
        this.characterAnalysis = characterAnalysis;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getProfessionalThinking() {
        return professionalThinking;
    }

    public void setProfessionalThinking(String professionalThinking) {
        this.professionalThinking = professionalThinking;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

