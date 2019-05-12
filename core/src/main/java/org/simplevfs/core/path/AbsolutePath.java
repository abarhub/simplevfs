package org.simplevfs.core.path;

import org.simplevfs.core.FileCommand;
import org.simplevfs.core.rootfs.Fs;
import org.simplevfs.core.utils.AssertUtils;

import java.util.Objects;

public class AbsolutePath extends AbstractPath {

    private final Fs fs;
    private final RootName name;
    private final String path;

    public AbsolutePath(Fs fs, RootName name, String path) {
        AssertUtils.verifyNotNull(fs,"Fs must not be null");
        AssertUtils.verifyNotNull(name,"Name must not be null");
        AssertUtils.verifyNotNull(path,"Path must not be null");
        this.fs=fs;
        this.name = name;
        this.path = path;
    }

    public RootName getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsolutePath that = (AbsolutePath) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(path, that.path);
    }

    public FileCommand getFileCommand(){
        return new FileCommand(this, fs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path);
    }

    @Override
    public String toString() {
        return "AbsolutePath{" +
                "name=" + name +
                ", path='" + path + '\'' +
                '}';
    }
}
