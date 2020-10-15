package web;


import domaine.Member;
import service.MemberService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberRessource {

    private final MemberService memberService;

    @Inject
    public MemberRessource(MemberService memberService) {
        this.memberService = memberService;
    }

    // @Path("/member/{id}") => @PathParam
    // @Path("/member") => @QueryParam
    // @Path("/member") => body

    @POST
    @Path("/{username}/{password}")
    public Response saveMember(@PathParam(value = "username") String username,@PathParam(value="password") String password) {
        Member member = new Member();
        member.setPassword(password);
        member.setUsername(username);
        return Response.ok().entity(memberService.addMember(member)).build();
    }
}
