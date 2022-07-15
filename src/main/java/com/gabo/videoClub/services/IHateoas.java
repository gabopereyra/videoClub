package com.gabo.videoClub.services;

import org.springframework.hateoas.Link;

import javax.servlet.http.HttpServletRequest;

public interface IHateoas <I>{
    Link getSelfLink(I id);

    Link getCollectionLink();

    Link getDeleteLink(I id);
}
