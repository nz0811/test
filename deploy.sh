echo "开始打包"
git checkout master
git pull

port=8088
mvn clean package -P pro -Dmaven.test.skip=true

declare targetJar=`ls ./target/*.jar | grep -v "sources"`
echo 'Get File Sucess: ' +  $targetJar

cp -rf $targetJar ROOT.jar

echo "准备下线服务test"
docker stop test
docker rm test
docker rmi test:1.0
echo "test已下线"

echo 开始构建镜像test
docker build -t test:1.0 .
echo test镜像构建完成

echo 开始运行容器test
docker run -d -p ${port}:${port} --net=host --name test test:1.0
echo test容器运行成功