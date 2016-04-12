package pt.tecnico.mydrive.service;

import pt.tecnico.mydrive.domain.*;
import pt.tecnico.mydrive.exception.EmptyFileNameException;
import pt.tecnico.mydrive.exception.IsNotCdAbleException;
import pt.tecnico.mydrive.exception.PermissionDeniedException;


public class CreateLinkService extends CreatePlainFileService {

    public CreateLinkService(String fileName, long token, String content) {
        super(fileName, token, content);
    }

    public CreateLinkService(String fileName, long token) {
        super(fileName, token, "");
    }

    @Override
    protected void dispatch() throws EmptyFileNameException, IsNotCdAbleException, PermissionDeniedException {
        super.dispatchAux();
        FileSystem fs = getFileSystem();
        Session s = fs.getSession(getToken());
        File f = fs.getFile(s.getWorkingPath());
        if (!f.isCdAble()) throw new IsNotCdAbleException();
        Directory d = (Directory) f;
        new Link(fs, d, s.getUser(), getContent());
    }
}
