If you are working on Mac/Linux you probably know how to use git, so go to step 3.

1). Download latest git client from:
http://code.google.com/p/msysgit/downloads/list

2). This step is very important, you will have lots of issues with merging if skipped.
In ${user.home} create file ".gitconfig" and add the following content (between ====================)
====================
[core]
	autocrlf = true
====================
It should be enough, however if still have issues please read following documentation:
https://help.github.com/articles/dealing-with-line-endings


3). Make sure you have GitHub account and you are added as collaborator.

4). Clone repo and add upstream: https://help.github.com/articles/fork-a-repo
Step 2 and Step 3
Valid upstream project: https://github.com/Jasig/cas, you can find url for upstream on it's page



=====================================
To deploy maven project to artifactory please there are 3 simple steps:

1). Configure repository settings in ${user.home}/.m2/settings.xml
        <server>
            <id>visiquate-local-repository</id>
            <username>contact-vq8-core-api-team-lead-for-username</username>
            <password>contact-vq8-core-api-team-lead-for-password</password>
        </server>

2). Change version in cas files (can be done using global replace on pom.xml):
<version>3.4.6-vq8coreapi-1.0.0</version> -> <version>3.4.6-vq8coreapi-1.0.1</version>

3). run "mvn deploy", if everything ok your fresh build should be available in vq8 local maven repo

4). Optionally, create git tag, please contact vq8-core-api-team-lead for support
