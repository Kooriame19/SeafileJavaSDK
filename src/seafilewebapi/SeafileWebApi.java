package seafilewebapi;

import java.io.File;
import java.util.List;

/**
 * @author freezingrainyu
 * @version 1.2
 * @date 2019/04/16
 */
public interface SeafileWebApi {

    /* module Ping */

    /**
     * ping
     * TESTED
     *
     * @return "pong"
     */
    String ping();

    /**
     * obtain the token of a specified account
     * TESTED
     *
     * @param username username whose token will be obtained
     * @param password password
     * @return token of specified user
     */
    String obtainAuthToken(String username, String password);

    /**
     * ping with a valid token
     * TESTED
     *
     * @param token token
     * @return "pong"
     */
    String authPing(String token);

    /* module Account */

    /**
     * obtain a list of all usernames
     * ADMIN ONLY
     * TESTED
     *
     * @param token token of admin
     * @return list of ListedAccountInfo objects with usernames in
     */
    List<ListedAccountInfo> listAccounts(String token);

    /**
     * get the info of a specified account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username whose info will be getted
     * @return GettedAccountInfo object with info in
     */
    GettedAccountInfo getAccountInfo(String token, String username);

    /**
     * create a new account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username of new account
     * @param password password of new account
     * @return create successfully or not
     */
    boolean createAccount(String token, String username, String password);

    /**
     * migrate all libraries of one account to another one
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param fromUser username whose libraries will be migrated
     * @param toUser   username of account where libraries will be placed
     * @return migrate successfully or not
     */
    boolean migrateAccount(String token, String fromUser, String toUser);

    /**
     * delete an existed account
     * ADMIN ONLY
     * TESTED
     *
     * @param token    token of admin
     * @param username username whose account will be deleted
     * @return delete successfully or not
     */
    boolean deleteAccount(String token, String username);

    /**
     * check the info of a specified account
     * TESTED
     *
     * @param token token of current account
     * @return CheckedAccountInfo object with info in
     */
    CheckedAccountInfo checkAccountInfo(String token);

    /**
     * get the info of the server
     * TESTED
     *
     * @return ServerInfo object with info in
     */
    ServerInfo getServerInfo();

    /* module Starred File */

    /**
     * obtain a list of all starred files
     * TESTED
     *
     * @param token token of current account
     * @return list of StarredFileInfo objects with info in
     */
    List<StarredFileInfo> listStarredFiles(String token);

    /** TODO : 500 */
    boolean starFile(String token, String repoId, String path);

    /**
     * unstar a specified file
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id which includes the file to be unstarred
     * @param path   file path
     * @return unstar successfully or not
     */
    boolean unStarFile(String token, String repoId, String path);

    /* module Library */

    /**
     * get the info of default library
     * TESTED
     *
     * @param token token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo getDefaultLibrary(String token);

    /**
     * create a default library
     * TESTED
     *
     * @param token token of current account
     * @return DefaultLibraryInfo object with info in
     */
    DefaultLibraryInfo createDefaultLibrary(String token);

    /**
     * obtain a list of all libraries
     * TESTED
     *
     * @param token token of current account
     * @return list of ListedLibraryInfo objects with info in
     */
    List<ListedLibraryInfo> listLibraries(String token);

    /**
     * get the info of a specified library
     * TESTED
     *
     * @param token  token of current account
     * @param repoId library id whose info will be getted
     * @return GettedLibraryInfo object with info in
     */
    GettedLibraryInfo getLibraryInfo(String token, String repoId);

    String getLibraryOwner(String token, String repoId);

    List<LibraryHistory> getLibraryHistory(String token, String repoId);

    LibraryInfo createLibrary(String token, String name, String desc, String password);

    boolean deleteLibrary(String token, String repoId);

    boolean renameLibrary(String token, String repoId, String newName);

    boolean createPublicLibrary(String token, String repoId);

    boolean removePublicLibrary(String token, String repoId);

    LibraryDownloadInfo fetchLibraryDownloadInfo(String token, String repoId);

    List<LibraryInfo> searchLibraries(String token, String keyword);

    /* module File */

    ViewInfo viewFile(String token, String repoId, String path);

    String downloadFile(String token, String repoId, String path, int reuse);

    FileInfo getFileDetail(String token, String repoId, String path);

    List<FileHistory> getFileHistory(String token, String repoId, String path);

    String downloadFileFromRevision(String token, String repoId, String path, String commitId);

    boolean createFile(String token, String repoId, String path);

    boolean renameFile(String token, String repoId, String path, String newName);

    boolean lockFile(String token, String repoId, String path);

    boolean unLockFile(String token, String repoId, String path);

    boolean moveFile(String token, String repoId, String path, String dstRepo, String dstDir);

    boolean copyFile(String token, String repoId, String path, String dstRepo, String dstDir);

    boolean revertFile(String token, String repoId, String path, String commitId);

    boolean deleteFile(String token, String repoId, String path);

    String getUploadLink(String token, String repoId, String path, int replace);

    boolean uploadFile(String token, String uploadLink, String parentDir, File... files);

    String getUpdateLink(String token, String repoId, String path);

    boolean updateFile(String token, String updateLink, String targetFile, File file);

    /* module Directory */

    List<DirectoryEntry> listDirectoryEntries(String token, String repoId, String path);

    boolean createNewDirectory(String token, String repoId, String path);

    boolean renameDirectory(String token, String repoId, String path, String newName);

    boolean deleteDirectory(String token, String repoId, String path);

    String downloadDirectory(String token, String repoId, String path);

    /* module Multiple Files or Directories */

    boolean multiCopy(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiMove(String token, String path, String dstRepo, String dstDir, String... fileNames);

    boolean multiDelete(String token, String path, String... fileNames);

    /* module Avatar */

    String getUserAvatar(String token, String username, String size);

    /* module File Activity */

    List<FileActivity> getFileActivities(String token);
}
