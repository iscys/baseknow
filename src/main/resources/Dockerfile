FROM  5ceee9310a16
RUN echo "start install redis ..."
RUN cd /tmp
RUN wget http://download.redis.io/releases/redis-4.0.9.tar.gz \
&& tar -zxvf redis-4.0.9.tar.gz \
&& cd redis-4.0.9 \
&& make \
&& cd src \
&& make install
EXPOSE 6379
